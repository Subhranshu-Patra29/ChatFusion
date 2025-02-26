package chatfusion.Chat.Forms;

import static chatfusion.chatbotAI.aiReplier.generateAIReply;
import com.darkprograms.speech.translator.GoogleTranslate;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JPanel;

public class Menu_Right extends JPanel {

    private HashMap<String, String> langISOCode;
    private String textMsg, translatedMsgText, aiResponse;

    public Menu_Right() {
        initComponents();
        init();
    }

    private void init() {

        //Initialize String with empty
        textMsg = "";
        translatedMsgText = "";
        aiResponse = "";

        langISOCode = new HashMap<>();
        langISOCode.put("Bengali", "bn");
        langISOCode.put("English", "en");
        langISOCode.put("French", "fr");
        langISOCode.put("German", "de");
        langISOCode.put("Gujarati", "gu");
        langISOCode.put("Hindi", "hi");
        langISOCode.put("Italian", "it");
        langISOCode.put("Kannada", "kn");
        langISOCode.put("Malayalam", "ml");
        langISOCode.put("Nepali", "ne");
        langISOCode.put("Odia", "or");
        langISOCode.put("Sanskrit", "sa");
        langISOCode.put("Spanish", "es");
        langISOCode.put("Tamil", "ta");
        langISOCode.put("Telugu", "te");
    }

    private String translateMsg(String toLang, String textMsg) {
//        removeEmoji(textMsg);
        try {
            return GoogleTranslate.translate(toLang, textMsg);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
//    private String removeEmoji(String textMsg) {
//        System.out.println(textMsg);
//        // Regular expression to match emojis
//        String emojiPattern = "[\\p{So}\\p{Cn}]";
//        
//        // Remove emojis from the string
//        String result = textMsg.replaceAll(emojiPattern, "");
//
//        System.out.println(result);
//        return result;
//    }
    
    private void dispTranslatedMsg(String text) {
        translatedMsg.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
        translatedMsg.setText(text);
    }

    private void dispAIReply(String text) {
        aiReplyBox.setFont(new Font("Nirmala UI", Font.PLAIN, 15));
        aiReplyBox.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        translateBtn1 = new javax.swing.JButton();
        chatTranslator = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        langSelect = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        langList = new javax.swing.JList<>();
        translatedmsgtxt = new javax.swing.JLabel();
        scrollpane2 = new javax.swing.JScrollPane();
        translatedMsg = new javax.swing.JTextArea();
        translateBtn = new javax.swing.JButton();
        chatfusionAI = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        aiReplyText = new javax.swing.JLabel();
        scrollpane3 = new javax.swing.JScrollPane();
        aiReplyBox = new javax.swing.JTextArea();
        aiReplyGenerateBtn = new javax.swing.JButton();
        aiReplyMaximizeBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(165, 165, 255));

        chatTranslator.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        chatTranslator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatTranslator.setText("Chat Translator");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        langSelect.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        langSelect.setText("Select Language ");

        langList.setBackground(new java.awt.Color(165, 165, 255));
        langList.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        langList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Bengali", "English", "French", "German", "Gujarati", "Hindi", "Italian", "Kannada", "Malayalam", "Nepali", "Odia", "Sanskrit", "Spanish", "Tamil", "Telugu", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        langList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        langList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollpane.setViewportView(langList);

        translatedmsgtxt.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        translatedmsgtxt.setText("Translated Message");

        scrollpane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        translatedMsg.setEditable(false);
        translatedMsg.setBackground(new java.awt.Color(165, 165, 255));
        translatedMsg.setColumns(20);
        translatedMsg.setLineWrap(true);
        translatedMsg.setRows(5);
        scrollpane2.setViewportView(translatedMsg);

        translateBtn.setBackground(new java.awt.Color(17, 16, 16));
        translateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/translate.png"))); // NOI18N
        translateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(langSelect)
                    .addComponent(translatedmsgtxt)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollpane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(translateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(langSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(translateBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(translatedmsgtxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollpane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        chatfusionAI.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        chatfusionAI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chatfusionAI.setText("ChatFusion AI");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        aiReplyText.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        aiReplyText.setText("AI Generated Reply");

        scrollpane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        aiReplyBox.setEditable(false);
        aiReplyBox.setBackground(new java.awt.Color(165, 165, 255));
        aiReplyBox.setColumns(20);
        aiReplyBox.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        aiReplyBox.setLineWrap(true);
        aiReplyBox.setRows(5);
        scrollpane3.setViewportView(aiReplyBox);

        aiReplyGenerateBtn.setBackground(new java.awt.Color(17, 16, 16));
        aiReplyGenerateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/gpt.png"))); // NOI18N
        aiReplyGenerateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aiReplyGenerateBtnActionPerformed(evt);
            }
        });

        aiReplyMaximizeBtn.setBackground(new java.awt.Color(17, 16, 16));
        aiReplyMaximizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatfusion/icon/maximize.png"))); // NOI18N
        aiReplyMaximizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aiReplyMaximizeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aiReplyText)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollpane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(aiReplyGenerateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(aiReplyMaximizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(aiReplyText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollpane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(aiReplyGenerateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aiReplyMaximizeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatTranslator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chatfusionAI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chatTranslator, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(chatfusionAI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void translateBtnActionPerformed(ActionEvent evt) {//GEN-FIRST:event_translateBtnActionPerformed
        String toLangSelected = langList.getSelectedValue();
        String langCode = langISOCode.get(toLangSelected);
//        System.out.println( toLangSelected + " " + langCode);
        textMsg = Chat_Body.getTextMsg();
        translatedMsgText = translateMsg(langCode, textMsg);
//        System.out.println(translatedMsgText);
        dispTranslatedMsg(translatedMsgText);
    }//GEN-LAST:event_translateBtnActionPerformed

    private void aiReplyGenerateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        textMsg = Chat_Body.getTextMsg();
        aiResponse = generateAIReply(textMsg);
        dispAIReply(aiResponse);
    }

    private void aiReplyMaximizeBtnActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AIReplyWindow obj = new AIReplyWindow();
                obj.setVisible(true);
                obj.setTexts(textMsg, aiResponse);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea aiReplyBox;
    private javax.swing.JButton aiReplyGenerateBtn;
    private javax.swing.JButton aiReplyMaximizeBtn;
    private javax.swing.JLabel aiReplyText;
    private javax.swing.JLabel chatTranslator;
    private javax.swing.JLabel chatfusionAI;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JList<String> langList;
    private javax.swing.JLabel langSelect;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JScrollPane scrollpane2;
    private javax.swing.JScrollPane scrollpane3;
    private javax.swing.JButton translateBtn;
    private javax.swing.JButton translateBtn1;
    private javax.swing.JTextArea translatedMsg;
    private javax.swing.JLabel translatedmsgtxt;
    // End of variables declaration//GEN-END:variables
}
