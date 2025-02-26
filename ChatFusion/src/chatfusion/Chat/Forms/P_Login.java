
package chatfusion.Chat.Forms;

import java.net.PortUnreachableException;

import chatfusion.Chat.Event.PublicEvent;
import chatfusion.Model.Model_Login;

public class P_Login extends javax.swing.JPanel {

    /**
     * Creates new form P_Login
     */
    public P_Login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        passwrd = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();
        cmdRegister = new javax.swing.JButton();

        setBackground(new java.awt.Color(165, 165, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(38, 35, 35));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("LOGIN");

        passwrd.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwrd.setForeground(new java.awt.Color(38, 35, 35));
        passwrd.setText("Password");

        txtUser.setBackground(new java.awt.Color(255, 247, 247));
        txtUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(38, 35, 35));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(38, 35, 35));
        username.setText("Username");

        txtPass.setBackground(new java.awt.Color(255, 247, 247));
        txtPass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(38, 35, 35));
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        cmdLogin.setBackground(new java.awt.Color(216, 210, 210));
        cmdLogin.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        cmdLogin.setForeground(new java.awt.Color(38, 35, 35));
        cmdLogin.setText("Login");
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        cmdRegister.setBackground(new java.awt.Color(255, 247, 247));
        cmdRegister.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmdRegister.setForeground(new java.awt.Color(75, 75, 216));
        cmdRegister.setText("Register");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwrd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(txtUser))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdRegister)
                        .addGap(36, 36, 36)))
                .addGap(20, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTitle)
                .addGap(30, 30, 30)
                .addComponent(username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwrd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdRegister))
                .addGap(0, 93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {
        PublicEvent.getInstance().getEventLogin().login(new Model_Login(txtUser.getText(), String.valueOf(txtPass.getPassword())));
    }

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void cmdRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        PublicEvent.getInstance().getEventLogin().goToRegister();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdLogin;
    private javax.swing.JButton cmdRegister;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel passwrd;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
