/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.awt.Color;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class MainForm extends javax.swing.JFrame {
    
    String username;
    String host;
    int port;
    Socket socket;
    DataOutputStream dos;
    public boolean attachmentOpen = false;
    private boolean isConnected = false;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }
    
    
    public void initFrame(String username, String host, int port){
        this.username = username;
        this.host = host;
        this.port = port;
        setTitle("you are logged in as: " + username);
        /** Connect **/
        connect();
    }
    
    public void connect(){
        appendMessage(" Connecting...", "Status", Color.WHITE, Color.WHITE);
        try {
            socket = new Socket(host, port);
            dos = new DataOutputStream(socket.getOutputStream());
            /** Send our username **/
            dos.writeUTF("CMD_JOIN "+ username);
            appendMessage(" Connected", "Status", Color.WHITE, Color.WHITE);
            appendMessage(" type your message now.!", "Status", Color.WHITE, Color.WHITE);
            
            /** Start Thread **/
            new Thread(new ClientThread(socket, this)).start();
            jButton1.setEnabled(true);
            // were now connected
            isConnected = true;
        }
        catch(IOException e) {
            isConnected = false;
            JOptionPane.showMessageDialog(this, "Unable to Connect to Server, please try again later.!","Connection Failed",JOptionPane.ERROR_MESSAGE);
            appendMessage("[IOException]: "+ e.getMessage(), "Error", Color.RED, Color.RED);
        }
    }
    
    /*
        is Connected
    */
    public boolean isConnected(){
        return this.isConnected;
    }
    
    /*
        System Message
    */
    public void appendMessage(String msg, String header, Color headerColor, Color contentColor){
        jTextPane1.setEditable(true);
        getMsgHeader(header, headerColor);
        getMsgContent(msg, contentColor);
        jTextPane1.setEditable(false);
    }
    
    /*
        My Message
    */
    public void appendMyMessage(String msg, String header){
        jTextPane1.setEditable(true);
        getMsgHeader(header, Color.BLACK);
        getMsgContent(msg, Color.BLACK);
        jTextPane1.setEditable(false);
    }
    
    /*
        Message Header
    */
    public void getMsgHeader(String header, Color color){
        int len = jTextPane1.getDocument().getLength();
        jTextPane1.setCaretPosition(len);
        jTextPane1.setCharacterAttributes(MessageStyle.styleMessageContent(color, "Bold", 13), false);
        jTextPane1.replaceSelection(header+":");
    }
    /*
        Message Content
    */
    public void getMsgContent(String msg, Color color){
        int len = jTextPane1.getDocument().getLength();
        jTextPane1.setCaretPosition(len);
        jTextPane1.setCharacterAttributes(MessageStyle.styleMessageContent(color, "Arial", 12), false);
        jTextPane1.replaceSelection(msg +"\n\n");
    }
    
    public void appendOnlineList(Vector list){
        jList1.removeAll();
        jList1.setListData(list);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 460));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setMinimumSize(new java.awt.Dimension(670, 460));
        jPanel1.setLayout(null);

        jTextPane1.setBackground(new java.awt.Color(0, 204, 204));
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 130, 460, 250);

        jList1.setBackground(new java.awt.Color(0, 204, 204));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(jList1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(520, 130, 130, 310);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(30, 400, 350, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/messenger/facebook-messenger-icon23.png"))); // NOI18N
        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(390, 400, 100, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Online Users");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(520, 70, 120, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/messenger/images (3).jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 10, 113, 110);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/messenger/VKTPd2M.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 670, 460);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
          try {
            String content = username+" "+ evt.getActionCommand();
            dos.writeUTF("CMD_CHATALL "+ content);
            appendMyMessage(" "+evt.getActionCommand(), username);
            jTextField1.setText("");
        } catch (IOException e) {
            appendMessage("[IOException]: "+ e.getMessage(), "Error", Color.RED, Color.RED);
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           try {
            String content = username+" "+ jTextField1.getText();
            dos.writeUTF("CMD_CHATALL "+ content);
            appendMyMessage(" "+jTextField1.getText(), username);
            jTextField1.setText("");
        } catch (IOException e) {
            appendMessage("[IOException]: "+ e.getMessage(), "Error", Color.RED, Color.RED);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
