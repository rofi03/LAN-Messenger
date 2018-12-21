/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Hp
 */
public class Server extends javax.swing.JFrame {
    
    String username;
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    ArrayList<String>userList=new ArrayList();
    Boolean isConnected=false;

    /**
     * Creates new form Server
     */
    public Server() {
        initComponents();
    }
    
     public class IncomingReader implements Runnable
    {
       
      
      public void run() {
       
       String stream;   
       String[]data;
       String done="Done",connect="Connect",disconnect="Disconnect",chat="Chat";
       
       try
       {
        while((stream=reader.readLine()) !=null)
        {
         data=stream.split(":");
         
         if(data[2].equals(chat))
         {
           chatTextArea.append(data[0]+": " +data[1]+"\n");
           
         }
         else if(data[2].equals(connect))
         {
           chatTextArea.removeAll();
           userAdd(data[0]);
         }
          else if(data[2].equals(disconnect))
         {
           userRemove(data[0]);
         }
          else if(data[2].equals(done))
         {
           //.setText("");    //usersList
           writeUsers();
           userList.clear();
         }   
        }
        
      }catch(Exception ex){
      
      
          }
       } 
   }
     
    
     public void ListenThread(){
     
     Thread IncomingReader=new Thread(new IncomingReader());
     IncomingReader.start();
     
     } 
     
     public void userAdd(String data)
     {
      userList.add(data);
     }
     
     public void userRemove(String data)
     {
      chatTextArea.append(data + "is now offline \n");
     }
     
     public void writeUsers()
     {
      String[] tempList=new String[(userList.size())];
      userList.toArray(tempList);
      for(String token:tempList)
      {
       //userList.append(token +"\n");      //userList
    
      }
   
     }
     
     public void sendDisconnect()
   {
    String bye=(username + ": :Disconnect");
    try
    {
     writer.println(bye);
     writer.flush();
    }
    catch(Exception e)
     {
      chatTextArea.append("Could not send Disconnect message.\n");
     }
   
   }
     
     
   public void Disconnect()
   {
       try
        {
          chatTextArea.append("Disconnect.\n");
          sock.close();
        }catch(Exception ex){
            chatTextArea.append("failed to Disconnect.\n");
           }
            isConnected=false;
            jTextField1.setEditable(true);
        //  userList.setText("");     //userList
    
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineUsersArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 500));

        jPanel1.setMinimumSize(new java.awt.Dimension(720, 500));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 165, 255));
        jLabel1.setText("username :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 40, 90, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(260, 40, 160, 30);

        jButton1.setText("connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(470, 40, 100, 30);

        jButton2.setText("disconnect");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(593, 40, 100, 30);

        onlineUsersArea.setBackground(new java.awt.Color(51, 204, 255));
        onlineUsersArea.setColumns(20);
        onlineUsersArea.setRows(5);
        jScrollPane1.setViewportView(onlineUsersArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 166, 330);

        chatTextArea.setBackground(new java.awt.Color(0, 204, 255));
        chatTextArea.setColumns(20);
        chatTextArea.setRows(5);
        jScrollPane2.setViewportView(chatTextArea);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(200, 180, 350, 260);

        jTextArea3.setBackground(new java.awt.Color(0, 204, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(570, 180, 130, 260);

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        jScrollPane4.setViewportView(inputTextArea);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(200, 450, 350, 60);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/messenger/facebook-messenger-icon.png"))); // NOI18N
        jButton3.setText("Send");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(570, 450, 120, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 165, 255));
        jLabel2.setText("Online Users");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 140, 90, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/messenger/images (3).jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 10, 110, 120);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/messenger/VKTPd2M.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 720, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        sendDisconnect();
        Disconnect();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String nothing="";
     if((inputTextArea.getText()).equals(nothing)) {
        inputTextArea.setText("");
        inputTextArea.requestFocus(); 
        }else{
        
            try{
               
                writer.println(username +"!"+ inputTextArea.getText()+"!"+ "Chat");
                writer.flush();     //flushes the buffer.
                
                
                /***************/
                chatTextArea.append(username +" :"+ inputTextArea.getText()+"!"+".\n");
                
            }catch(Exception ex)
            {
             chatTextArea.append("Message was not sent.\n");
            }
            inputTextArea.setText("");
            inputTextArea.requestFocus();
        }
         inputTextArea.setText("");
         inputTextArea.requestFocus();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
      if(isConnected==false)
      {
       username=jTextField1.getText();
       jTextField1.setEditable(false);
       
       try
       {
        sock=new Socket("127.0.0.1",5000);
        InputStreamReader streamreader=new InputStreamReader(sock.getInputStream());
        reader=new BufferedReader(streamreader);
        writer=new PrintWriter(sock.getOutputStream());
        writer.println(username+"!has connected.!Connect");          //display to every one that user is connected.
        writer.flush();            //flushes the buffer.
        isConnected=true;          //used to see if the client is connected.
        /**************************/
        chatTextArea.append(username+">> is Connect Now!.\n");
        onlineUsersArea.append(username);
       //tellEveryone("chatTextArea");
       //tellEveryone("onlineUsersArea");
        
       }catch(Exception ex)
       {
         chatTextArea.append("Cannot connect! Try Again.\n");
         jTextField1.setEditable(true);
       }
        ListenThread();
      
      }else if(isConnected==true)
      {
       chatTextArea.append("You are all ready connected.\n");
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    public javax.swing.JTextField jTextField1;
    
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    //private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea onlineUsersArea;
    
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea onlineUsersArea;
    // End of variables declaration//GEN-END:variables
*/
    }