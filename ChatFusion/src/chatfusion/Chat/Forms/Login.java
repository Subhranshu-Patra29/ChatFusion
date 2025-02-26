package chatfusion.Chat.Forms;

import chatfusion.Chat.Event.EventLogin;
import chatfusion.Chat.Event.EventMessage;
import chatfusion.Chat.Event.PublicEvent;
import chatfusion.Model.Model_Login;
import chatfusion.Model.Model_Message;
import chatfusion.Model.Model_Register;
import chatfusion.Model.Model_User_Account;
import chatfusion.Service.Service;
import io.socket.client.Ack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JPanel {

    public Login() {
        initComponents();
        init();
    }

    private void init() {
        PublicEvent.getInstance().addEventLogin(new EventLogin() {
            @Override
            public void login(Model_Login data) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PublicEvent.getInstance().getEventMain().showLoading(true);
                        Service.getInstance().getClient().emit("login", data.toJSONObject(), new Ack() {
                            @Override
                            public void call(Object... os) {
                                if(os.length > 0) {
                                    boolean action = (Boolean)os[0];
                                    if(action) {
                                        Service.getInstance().setUser(new Model_User_Account(os[1]));
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                                        PublicEvent.getInstance().getEventMain().initChat();
                                    }
                                    else {
                                        //WRONG PASSWORD
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                                        JOptionPane.showMessageDialog(new JFrame(), "Wrong Username and Password!", "ERROR", JOptionPane.ERROR_MESSAGE);

                                    }
                                }
                                else {
                                    PublicEvent.getInstance().getEventMain().showLoading(false);
                                }
                            }
                            
                        });
                    }
                }).start();
            }

            @Override
            public void register(Model_Register data, EventMessage message) {
                Service.getInstance().getClient().emit("register", data.toJSONObject(), new Ack(){
                    @Override
                    public void call(Object... os) {
                        if(os.length > 0) {
                            Model_Message ms = new Model_Message((boolean)os[0], os[1].toString());
                            if(ms.isAction()) {
                                Model_User_Account user = new Model_User_Account(os[2]);
                                Service.getInstance().setUser(user);
                            }
                            message.callMessage(ms);
                        }
                    }
                });
            }

            @Override
            public void goToRegister() {
                slide.show(1);
            }

            @Override
            public void goBackToLogin() {
                slide.show(0);
            }
        });
        P_Login login = new P_Login();
        P_Register register = new P_Register();
        slide.init(login, register);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox2 = new chatfusion.Chat.PictureBox();
        pic = new chatfusion.Chat.PictureBox();
        chatfusion = new javax.swing.JLabel();
        downline = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel();
        logo = new chatfusion.Chat.ImageAvatar();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        slide = new chatfusion.Chat.PanelSlide();

        setBackground(new java.awt.Color(255, 255, 255));

        pic.setImage(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/login_image.png"))); // NOI18N

        chatfusion.setFont(new java.awt.Font("Segoe Script", 0, 20)); // NOI18N
        chatfusion.setForeground(new java.awt.Color(38, 45, 127));
        chatfusion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatfusion.setText("ChatFusion");
        pic.add(chatfusion);
        chatfusion.setBounds(0, 450, 600, 40);

        downline.setBackground(new java.awt.Color(55, 71, 154));
        downline.setOpaque(true);

        logoPanel.setBackground(new java.awt.Color(255, 255, 255));

        logo.setBorderSize(0);
        logo.setImage(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/img2.jpg"))); // NOI18N

        javax.swing.GroupLayout logoPanelLayout = new javax.swing.GroupLayout(logoPanel);
        logoPanel.setLayout(logoPanelLayout);
        logoPanelLayout.setHorizontalGroup(
                logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(123, Short.MAX_VALUE)));
        logoPanelLayout.setVerticalGroup(
                logoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(logoPanelLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel1.setBackground(new java.awt.Color(55, 71, 154));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
                slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 291, Short.MAX_VALUE));
        slideLayout.setVerticalGroup(
                slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 341, Short.MAX_VALUE));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(downline, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 610,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 483,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(downline, javax.swing.GroupLayout.PREFERRED_SIZE, 7,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chatfusion;
    private javax.swing.JLabel downline;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private chatfusion.Chat.ImageAvatar logo;
    private javax.swing.JPanel logoPanel;
    private chatfusion.Chat.PictureBox pic;
    private chatfusion.Chat.PictureBox pictureBox2;
    private chatfusion.Chat.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
