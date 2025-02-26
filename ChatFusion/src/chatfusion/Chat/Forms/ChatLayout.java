
package chatfusion.Chat.Forms;

import chatfusion.Chat.Event.PublicEvent;
import chatfusion.Model.Model_User_Account;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class ChatLayout extends javax.swing.JPanel {

    private final Model_User_Account user;
    private boolean mouseOver;
    
    public Model_User_Account getUser() {
        return user;
    }
    
    public ChatLayout(Model_User_Account user) {
        this.user = user;
        initComponents();
        username.setText(user.getUsername());
        activeStatus.setActive(user.isStatus());
        init();
    }
    
    public void updateStatus() {
        activeStatus.setActive(user.isStatus());
    }
    
    private void init() {
        addMouseListener(new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent me) {
               setBackground(new Color(122,122,255));
               mouseOver = true;
           }
           
           @Override 
           public void mouseExited(MouseEvent me) {
               setBackground(new Color(165,165,255));
               mouseOver = false;
           }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(mouseOver) {
                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
           
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new chatfusion.ImageAvatar();
        username = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        activeStatus = new chatfusion.Chat.ActiveStatus();

        setBackground(new java.awt.Color(165, 165, 255));
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(205, 50));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/profile.png"))); // NOI18N

        username.setFont(new java.awt.Font("Segoe Print", 0, 15)); // NOI18N
        username.setForeground(new java.awt.Color(51, 51, 51));
        username.setText("Username");
        username.setToolTipText("");

        lbStatus.setFont(new java.awt.Font("Segoe Print", 2, 12)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(51, 51, 51));
        lbStatus.setText("Name");
        lbStatus.setToolTipText("");

        activeStatus.setActive(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbStatus)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chatfusion.Chat.ActiveStatus activeStatus;
    private chatfusion.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    
}
