
package chatfusion.Chat.Forms;

import chatfusion.Chat.Event.EventMessage;
import chatfusion.Chat.Event.PublicEvent;
import chatfusion.Model.Model_Message;
import chatfusion.Model.Model_Register;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class P_Register extends javax.swing.JPanel {


    public P_Register() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        cnfpasswrd = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        phone = new javax.swing.JLabel();
        txtRePass = new javax.swing.JPasswordField();
        cmdRegister = new javax.swing.JButton();
        cmdBackLogin = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        passwrd = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(165, 165, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(38, 35, 35));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("REGISTER");

        cnfpasswrd.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cnfpasswrd.setForeground(new java.awt.Color(38, 35, 35));
        cnfpasswrd.setText("Confirm Password");

        txtUser.setBackground(new java.awt.Color(255, 247, 247));
        txtUser.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(38, 35, 35));
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        phone.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        phone.setForeground(new java.awt.Color(38, 35, 35));
        phone.setText("Phone No.");

        txtRePass.setBackground(new java.awt.Color(255, 247, 247));
        txtRePass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtRePass.setForeground(new java.awt.Color(38, 35, 35));

        cmdRegister.setBackground(new java.awt.Color(216, 210, 210));
        cmdRegister.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        cmdRegister.setForeground(new java.awt.Color(38, 35, 35));
        cmdRegister.setText("Register");
        cmdRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRegisterActionPerformed(evt);
            }
        });

        cmdBackLogin.setBackground(new java.awt.Color(255, 247, 247));
        cmdBackLogin.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmdBackLogin.setForeground(new java.awt.Color(75, 75, 216));
        cmdBackLogin.setText("Back to Login");
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBackLoginActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(38, 35, 35));
        username.setText("Username");

        passwrd.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        passwrd.setForeground(new java.awt.Color(38, 35, 35));
        passwrd.setText("Password");

        txtPhone.setBackground(new java.awt.Color(255, 247, 247));
        txtPhone.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(38, 35, 35));
        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        txtPass.setBackground(new java.awt.Color(255, 247, 247));
        txtPass.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(38, 35, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(passwrd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cnfpasswrd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtRePass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdBackLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwrd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cnfpasswrd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdBackLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(10, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {
    
    }

    private void cmdRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        String user = txtUser.getText().trim();
        String phone_no = txtPhone.getText().trim();
        String password = String.valueOf(txtPass.getPassword());
        String cnfPassword = String.valueOf(txtRePass.getPassword());
        
        if(user.equals("")){
            txtUser.grabFocus();
        }
        else if(phone_no.equals("")) {
            txtPhone.grabFocus();
        }
        else if(password.equals("")) {
            txtPass.grabFocus();
        }
        else if(!password.equals(cnfPassword)) {
            txtPass.grabFocus();
        }
        else {
            Model_Register data = new Model_Register(user, password, phone_no);
            PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
                @Override
                public void callMessage(Model_Message message) {
                    if(!message.isAction()) {
                        resetPanel();
                        JOptionPane.showMessageDialog(new JFrame(), message.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        resetPanel();
                        JOptionPane.showMessageDialog(new JFrame(), message.getMessage(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                        PublicEvent.getInstance().getEventLogin().goBackToLogin();//.getEventMain().initChat();
                    }
                }
            });
        }
    }
    
    private void resetPanel() {
        txtUser.setText("");
        txtPhone.setText("");
        txtPass.setText("");
        txtRePass.setText("");
    }

    private void cmdBackLoginActionPerformed(java.awt.event.ActionEvent evt) {
        PublicEvent.getInstance().getEventLogin().goBackToLogin();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBackLogin;
    private javax.swing.JButton cmdRegister;
    private javax.swing.JLabel cnfpasswrd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel passwrd;
    private javax.swing.JLabel phone;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JPasswordField txtRePass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
