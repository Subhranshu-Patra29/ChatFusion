
package chatfusion.Chat.Forms;

import java.awt.Color;
import javax.swing.Icon;

public class Chat_Left_with_Profile extends javax.swing.JLayeredPane {

    public Chat_Left_with_Profile() {
        initComponents();
        txt.setBackground(new Color(158, 202, 200));
    } 
    
    public void setUserProfile(String user) {
        txt.setUserProfile(user);
    }
    public void setImageProfile(Icon image) {
        dp.setImage(image);
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
    public void setImage(String... image) {
        //txt.setImage(false, image);
    }
    public void setFile(String fileName, String size) {
        txt.setFile(fileName, size);
    }
    public void setTime() {
        txt.setTime("10:30 PM");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        dp = new chatfusion.ImageAvatar();
        txt = new chatfusion.Chat.Forms.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        dp.setBorderSize(0);
        dp.setImage(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/profile2.png"))); // NOI18N
        dp.setMaximumSize(new java.awt.Dimension(30, 30));
        dp.setMinimumSize(new java.awt.Dimension(30, 30));
        dp.setPreferredSize(new java.awt.Dimension(30, 30));

        jLayeredPane1.setLayer(dp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chatfusion.ImageAvatar dp;
    private javax.swing.JLayeredPane jLayeredPane1;
    private chatfusion.Chat.Forms.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
