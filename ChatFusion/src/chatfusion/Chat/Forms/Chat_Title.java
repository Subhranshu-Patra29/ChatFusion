package chatfusion.Chat.Forms;

import chatfusion.Model.Model_User_Account;
import java.awt.Color;

public class Chat_Title extends javax.swing.JPanel {

    private Model_User_Account user;

    public Chat_Title() {
        initComponents();
    }

    public void setUserName(Model_User_Account user) {
        this.user = user;
        lbName.setText(user.getUsername());
        if (user.isStatus()) {
            statusActive();
        } else {
            setStatus("Offline");
        }
    }

    public void updateUser(Model_User_Account user) {
        if (this.user == user) {
            lbName.setText(user.getUsername());
            if (user.isStatus()) {
                statusActive();
            } else {
                setStatus("Offline");
            }
        }
    }

    public Model_User_Account getUser() {
        return user;
    }

    private void statusActive() {
        lbStatus.setText("Active now");
        lbStatus.setForeground(new Color(76,76,255));
    }

    private void setStatus(String text) {
        lbStatus.setText(text);
        lbStatus.setForeground(new Color(255,0,0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(165, 165, 255));
        setPreferredSize(new java.awt.Dimension(400, 40));

        layer.setLayout(new java.awt.GridLayout(0, 1));

        lbName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lbName.setText("Name");
        layer.add(lbName);

        lbStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(76, 76, 255));
        lbStatus.setText("Active now");
        layer.add(lbStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables

}
