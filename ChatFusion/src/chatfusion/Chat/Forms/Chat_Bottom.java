package chatfusion.Chat.Forms;

import chatfusion.Chat.JIMSendTextPane;
import chatfusion.Chat.Event.PublicEvent;
import chatfusion.Model.Model_Send_Message;
import chatfusion.Model.Model_User_Account;
import chatfusion.Service.Service;
import chatfusion.app.MessageType;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Chat_Bottom extends javax.swing.JPanel {

    private Model_User_Account user;
    private MigLayout mig;
    private Panel_More panelMore;
    
    
    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
        panelMore.setUser(user);
    }

    public Chat_Bottom() {
        initComponents();
        init();
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "0[fill]0[]0[]2 ", "2[fill]2[]0");
        setLayout(mig);

        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.setFont(new Font("Courier", Font.PLAIN, 17));
        txt.setBackground(new Color(223, 223, 210));
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                refresh();
                if (e.getKeyChar() == 10 && e.isControlDown()) {
                    //USER PRESS CTRL + ENTER
                    eventSend(txt);
                }
            }
        });
        txt.setBorder(new EmptyBorder(5, 5, 5, 5));
        txt.setHintText("Type a message ...");
        scroll.setViewportView(txt);

        ScrollBar sb = new ScrollBar();
        sb.setBackground(new Color(102, 102, 255));
        sb.setPreferredSize(new Dimension(3, 10));
        scroll.setVerticalScrollBar(sb);
        add(sb);
        add(scroll, "w 100%");

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(35, 35));
        panel.setBackground(Color.WHITE);

        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/chatfusion/icon/send2.png")));

        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/chatfusion/icon/more_disable.png")));

        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventSend(txt);
            }
        });
        cmdMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelMore.isVisible()) {
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/chatfusion/icon/more_disable.png")));
                    panelMore.setVisible(false);
                    mig.setComponentConstraints(panelMore, "dock south, h 0!");
                    revalidate();
                } else {
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/chatfusion/icon/more.png")));
                    panelMore.setVisible(true);
                    mig.setComponentConstraints(panelMore, "dock south, h 170!");
                    revalidate();
                }
            }
        });
        panel.add(cmdMore);
        panel.add(cmd);
        add(panel, "wrap");
        panelMore = new Panel_More();
        panelMore.setVisible(false);
        add(panelMore, "dock south,h 0!");
    }

    private void eventSend(JIMSendTextPane txt) {
        String text = txt.getText().trim();
        if (!text.equals("")) {
            Model_Send_Message message = new Model_Send_Message(MessageType.TEXT, Service.getInstance().getUser().getUserID(), user.getUserID(), text);
            send(message);
            PublicEvent.getInstance().getEventChat().sendMessage(message);
            txt.setText("");
            txt.grabFocus();
            refresh();
        } else {
            txt.grabFocus();
        }
    }

    private void send(Model_Send_Message data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
    }

    private void refresh() {
        revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
