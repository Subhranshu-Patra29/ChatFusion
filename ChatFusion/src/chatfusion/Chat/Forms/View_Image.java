package chatfusion.Chat.Forms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
import javax.swing.SwingUtilities;

import chatfusion.Chat.Event.PublicEvent;
import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

public class View_Image extends javax.swing.JComponent {

    public View_Image() {
        initComponents();
    }

    private Icon image;
    public void viewImage(Icon image) {
        this.image = image;
        pic.setImage(image);
        setVisible(true);
    }
    public void saveImage(String filename) {
        try {
        String path = "D:\\JAVA\\ChatFusion\\src\\chatfusion\\downloads";
        File directory = new File(path);
        if(!directory.exists()) {
            directory.mkdir();
        }
        File sourceFile = null;
        File destinationFile = null;
        String filenm = filename.substring(filename.lastIndexOf('/') + 1);
        String extension = filenm.substring(filenm.lastIndexOf('.') + 1);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        sourceFile = new File("D:\\photos a22\\" + filenm);
        destinationFile = new File(path + "\\dwnld" + timestamp + "." + extension);
        Files.copy(sourceFile.toPath(), destinationFile.toPath());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new chatfusion.Chat.PictureBox();
        cmdSave = new javax.swing.JButton();

        pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                picMousePressed(evt);
            }
        });

        cmdSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/save.png"))); // NOI18N
        cmdSave.setContentAreaFilled(false);
        cmdSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });

        pic.setLayer(cmdSave, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picLayout.createSequentialGroup()
                .addGap(0, 680, Short.MAX_VALUE)
                .addComponent(cmdSave))
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picLayout.createSequentialGroup()
                .addGap(0, 449, Short.MAX_VALUE)
                .addComponent(cmdSave))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {
        PublicEvent.getInstance().getEventImageView().saveImage(image);
    }

    private void picMousePressed(java.awt.event.MouseEvent evt) {
        if(SwingUtilities.isLeftMouseButton(evt)) {
            setVisible(false);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdSave;
    private chatfusion.Chat.PictureBox pic;
    // End of variables declaration//GEN-END:variables
}
