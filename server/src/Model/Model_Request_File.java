package Model;

public class Model_Request_File {
    
    private int fileID;
    private long currentLengh;

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public long getCurrentLengh() {
        return currentLengh;
    }

    public void setCurrentLengh(long currentLengh) {
        this.currentLengh = currentLengh;
    }

    public Model_Request_File() {
    }

    public Model_Request_File(int fileID, long currentLengh) {
        this.fileID = fileID;
        this.currentLengh = currentLengh;
    }
}
