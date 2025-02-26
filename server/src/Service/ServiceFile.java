package Service;

import Connection.DatabaseConnection;
import Model.Model_File;
import Model.Model_File_Receiver;
import Model.Model_Package_Sender;
import Model.Model_Receive_Image;
import Model.Model_Send_Message;
import App.MessageType;
import BlurHash.BlurHash;
import Model.Model_File_Sender;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ServiceFile {

    private final Connection conn;
    private final Map<Integer, Model_File_Receiver> fileReceivers;
    private final Map<Integer, Model_File_Sender> fileSenders;
    
    public ServiceFile() {
        this.conn = DatabaseConnection.getInstance().getConnection();
        this.fileReceivers = new HashMap<>();
        this.fileSenders = new HashMap<>();
    }

    //SQL
    private final String PATH_FILE = "D:\\JAVA\\server\\Server_Data\\";
    private final String INSERT = "INSERT INTO FILES (FileExtension) VALUES (?);";
    private final String UPDATE_BLUR_HASH_DONE = "UPDATE FILES SET BlurHash = ?, Status = '1' WHERE FileID = ? LIMIT 1";
    private final String UPDATE_DONE = "UPDATE FILES SET Status = '1' WHERE FileID = ? LIMIT 1";
    private final String GET_FILE_EXTENSION = "SELECT FileExtension FROM FILES WHERE FileID = ? LIMIT 1;";
    
    public Model_File addFileReceiver(String fileExtension) throws SQLException {
        Model_File data;
        PreparedStatement p = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        p.setString(1, fileExtension);
        p.execute();
        ResultSet r = p.getGeneratedKeys();
        r.first();
        int fileID = r.getInt(1);
        data = new Model_File(fileID, fileExtension);
        r.close();
        p.close();
        return data;
    }
    
    public void updateBlurHashDone(int fileID, String blurhash) throws SQLException {
        PreparedStatement p = conn.prepareStatement(UPDATE_BLUR_HASH_DONE);
        p.setString(1, blurhash);
        p.setInt(2, fileID);
        p.execute();
        p.close();
    }
    
    public void updateDone(int fileID) throws SQLException {
        PreparedStatement p = conn.prepareStatement(UPDATE_DONE);
        p.setInt(1, fileID);
        p.execute();
        p.close();
    }
    
    public void initFile(Model_File file, Model_Send_Message message) throws IOException {
        fileReceivers.put(file.getFileID(), new Model_File_Receiver(message, toFileObject(file)));
    }
    
    public Model_File getFile(int fileID) throws SQLException {
        PreparedStatement p = conn.prepareStatement(GET_FILE_EXTENSION, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        p.setInt(1, fileID);
        ResultSet r = p.executeQuery();
        r.first();
        String fileExtension = r.getString(1);
        Model_File data = new Model_File(fileID, fileExtension);
        r.close();
        p.close();
        return data;
    }

    public synchronized Model_File initFile(int fileID) throws IOException, SQLException {
        Model_File file;
        if (!fileSenders.containsKey(fileID)) {
            file = getFile(fileID);
            fileSenders.put(fileID, new Model_File_Sender(file, new File(PATH_FILE + fileID + file.getFileExtension())));
        } else {
            file = fileSenders.get(fileID).getData();
        }
        return file;
    }

    public byte[] getFileData(long currentLength, int fileID) throws IOException, SQLException {
        initFile(fileID);
        return fileSenders.get(fileID).read(currentLength);
    }

    public long getFileSize(int fileID) {
        return fileSenders.get(fileID).getFileSize();
    }
    
    public void receiveFile(Model_Package_Sender dataPackage) throws IOException {
        if(!dataPackage.isFinish()) {
            fileReceivers.get(dataPackage.getFileID()).writeFile(dataPackage.getData());
        }
        else {
            fileReceivers.get(dataPackage.getFileID()).close();
        }
    }
    
    public Model_Send_Message closeFile(Model_Receive_Image dataImage) throws IOException, SQLException {
        Model_File_Receiver file = fileReceivers.get(dataImage.getFileID());
        if(file.getMessage().getMessageType() == MessageType.IMAGE.getValue()) {
            //create blurhash
            file.getMessage().setText("");
            String blurhash = convertFileToBlurHash(file.getFile(), dataImage);
            updateBlurHashDone(dataImage.getFileID(), blurhash);
        } else {
            updateDone(dataImage.getFileID());
        }
        fileReceivers.remove(dataImage.getFileID());
        //GET MESSAGE TO SEND TO TARGET CLIENT WHEN FILE RECEIVE FINISH
        return file.getMessage();
    }
    
    private String convertFileToBlurHash(File file, Model_Receive_Image dataImage) throws IOException {
        BufferedImage img = ImageIO.read(file);
        Dimension size = getAutoSize(new Dimension(img.getWidth(), img.getHeight()), new Dimension(200, 200));
        //  Convert image to small size
        BufferedImage newImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        g2.drawImage(img, 0, 0, size.width, size.height, null);
        String blurhash = BlurHash.encode(newImage);
        dataImage.setWidth(size.width);
        dataImage.setHeight(size.height);
        dataImage.setImage(blurhash);
        return blurhash;
    }
    
    private Dimension getAutoSize(Dimension fromSize, Dimension toSize) {
        int w = toSize.width;
        int h = toSize.height;
        int iw = fromSize.width;
        int ih = fromSize.height;
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.min(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        return new Dimension(width, height);
    }
    
    private File toFileObject(Model_File file) {
        return new File(PATH_FILE + file.getFileID() + file.getFileExtension());
    }
}
