/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class MainForm extends javax.swing.JFrame {
    
     SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    Thread t;
    ServerThread serverThread;
    /** Chat List  **/
    public Vector socketList = new Vector();
    public Vector clientList = new Vector();
    /** File Sharing List **/
    public Vector clientFileSharingUsername = new Vector();
    public Vector clientFileSharingSocket = new Vector();
    /** Server **/
    ServerSocket server;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }
    
     
    public void appendMessage(String msg){
        Date date = new Date();
        jTextArea1.append(sdf.format(date) +": "+ msg +"\n");
        jTextArea1.setCaretPosition(jTextArea1.getText().length() - 1);
    }
    
      /** Setters **/
    public void setSocketList(Socket socket){
        try {
            socketList.add(socket);
            appendMessage("[setSocketList]: Added");
        } catch (Exception e) { appendMessage("[setSocketList]: "+ e.getMessage()); }
    }
    public void setClientList(String client){
        try {
            clientList.add(client);
            appendMessage("[setClientList]: Added");
        } catch (Exception e) { appendMessage("[setClientList]: "+ e.getMessage()); }
    }
    public void setClientFileSharingUsername(String user){
        try {
            clientFileSharingUsername.add(user);
        } catch (Exception e) { }
    }
    
    public void setClientFileSharingSocket(Socket soc){
        try {
            clientFileSharingSocket.add(soc);
        } catch (Exception e) { }
    }
    
    /** Getters
     * 
     * @param client
     * @return  **/
    public Socket getClientList(String client){
        Socket tsoc = null;
        for(int x=0; x < clientList.size(); x++){
            if(clientList.get(x).equals(client)){
                tsoc = (Socket) socketList.get(x);
                break;
            }
        }
        return tsoc;
    }
    
    
    public void removeFromTheList(String client){
        try {
            for(int x=0; x < clientList.size(); x++){
                if(clientList.elementAt(x).equals(client)){
                    clientList.removeElementAt(x);
                    socketList.removeElementAt(x);
                    appendMessage("[Removed]: "+ client);
                    break;
                }
            }
        } catch (Exception e) {
            appendMessage("[RemovedException]: "+ e.getMessage());
        }
    }
    
    public Socket getClientFileSharingSocket(String username){
        Socket tsoc = null;
        for(int x=0; x < clientFileSharingUsername.size(); x++){
            if(clientFileSharingUsername.elementAt(x).equals(username)){
                tsoc = (Socket) clientFileSharingSocket.elementAt(x);
                break;
            }
        }
        return tsoc;
    }
    
     public void removeClientFileSharing(String username){
        for(int x=0; x < clientFileSharingUsername.size(); x++){
            if(clientFileSharingUsername.elementAt(x).equals(username)){
                try {
                    clientFileSharingUsername.removeElementAt(x);
                    clientFileSharingSocket.removeElementAt(x);
                    appendMessage("[FileSharing]: Removed "+ username);
                } catch (Exception e) {
                    appendMessage("[FileSharing]: Unable to Remove "+ username);
                }
                break;
            }
        }
    }
    
    
    
    /*

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 400));

        jPanel1.setMinimumSize(new java.awt.Dimension(550, 400));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("port :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(18, 14, 50, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setText("4444");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(80, 10, 116, 33);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Server Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(237, 11, 120, 33);

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Server Stop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(392, 11, 120, 33);

        jTextArea1.setBackground(new java.awt.Color(0, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(39, 91, 470, 280);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/wood_planks___d632_by_agf81-d5fz4zl.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 550, 400);

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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int confirm = JOptionPane.showConfirmDialog(null, "Close Server.?");
        if(confirm == 0){
            serverThread.stop();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int port = Integer.parseInt(jTextField1.getText());
        serverThread = new ServerThread(port, this);
        t = new Thread(serverThread);
        t.start();
        
        new Thread(new OnlineListThread(this)).start();
        
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}