
package chatfusion.Chat.Forms;

import chatfusion.Model.Model_Receive_Image;
import java.awt.Color;

import javax.swing.Icon;

public class Chat_Left extends javax.swing.JLayeredPane {

    public Chat_Left() {
        initComponents();
        txt.setBackground(new Color(158, 202, 200));
    }

    public void setText(String text) {
        if(text.equals(""))
            txt.hideText();
        else
            txt.setText(text);
    }
    public void setImage(Icon... image) {
        //txt.setImage(false, image);
    }
    public void setImage(Model_Receive_Image dataImage) {
        txt.setImage(false, dataImage);
    }
    public void setFile(String fileName, String size) {
        txt.setFile(fileName, size);
    }
    public void setEmoji(Icon icon) {
        txt.hideText();
        txt.setEmoji(false, icon);
    }
    public void setTime() {
        txt.setTime("10:30 PM");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new chatfusion.Chat.Forms.Chat_Item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chatfusion.Chat.Forms.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
