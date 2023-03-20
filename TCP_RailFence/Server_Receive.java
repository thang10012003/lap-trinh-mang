/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TCP_RailFence;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JFrame;

/**
 *
 * @author APC
 */
public class Server_Receive extends javax.swing.JFrame {

    /**
     * Creates new form Server_Receive
     */
    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream data_input;
    static DataOutputStream data_output;
    static String filename;
    static byte[] data;
    public Server_Receive() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        XacNhan = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        Yes_Button = new javax.swing.JButton();
        No_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jText_MSG = new javax.swing.JTextArea();

        XacNhan.setTitle("Xác Nhận");
        XacNhan.setBounds(new java.awt.Rectangle(0, 0, 400, 400));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Do You Want to Download this file?");

        Yes_Button.setText("Yes");
        Yes_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Yes_ButtonActionPerformed(evt);
            }
        });

        No_Button.setText("No");
        No_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout XacNhanLayout = new javax.swing.GroupLayout(XacNhan.getContentPane());
        XacNhan.getContentPane().setLayout(XacNhanLayout);
        XacNhanLayout.setHorizontalGroup(
            XacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XacNhanLayout.createSequentialGroup()
                .addGroup(XacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(XacNhanLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(Yes_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(No_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(XacNhanLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        XacNhanLayout.setVerticalGroup(
            XacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XacNhanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(XacNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Yes_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("File Client Sent");
        jLabel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel1PropertyChange(evt);
            }
        });

        jText_MSG.setEditable(false);
        jText_MSG.setColumns(20);
        jText_MSG.setRows(5);
        jScrollPane2.setViewportView(jText_MSG);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1PropertyChange

    private void Yes_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Yes_ButtonActionPerformed
        // TODO add your handling code here:
        File filetoDownload = new File(filename);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filetoDownload);
            fileOutputStream.write(data);
            fileOutputStream.close();

            XacNhan.dispose();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }//GEN-LAST:event_Yes_ButtonActionPerformed

    private void No_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No_ButtonActionPerformed
        // TODO add your handling code here:
            XacNhan.dispose();
    }//GEN-LAST:event_No_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Server_Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_Receive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server_Receive().setVisible(true);
            }
        });
        try {
            serverSocket = new ServerSocket(5000);
            socket = serverSocket.accept();
            while(true){
                data_input = new DataInputStream(socket.getInputStream());

                int fileNameLength = data_input.readInt();

                if(fileNameLength > 0){
                    byte[] filenameByte = new byte[fileNameLength]; 
                    data_input.readFully(filenameByte, 0, filenameByte.length);
                    String fileName1 = new String(filenameByte);
                    filename = fileName1;

                    int fileContentLength = data_input.readInt();
                    
                    if(fileContentLength > 0){
                        byte[] fileContentByte = new byte[fileContentLength];
                        data_input.readFully(fileContentByte, 0, fileContentLength );
                        data = fileContentByte;

                    }
                    jText_MSG.setText("Client vừa gửi cho bạn 1 file:\t"+fileName1);

                    XacNhan.setVisible(true);
                }
                
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton No_Button;
    private static javax.swing.JFrame XacNhan;
    private javax.swing.JButton Yes_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea jText_MSG;
    // End of variables declaration//GEN-END:variables
}

// File filetoDownload = new File(filename);

// try {
//     FileOutputStream fileOutputStream = new FileOutputStream(filetoDownload);
//     fileOutputStream.write(fileData);
//     fileOutputStream.close;

//     jFrame.dispose();
// } catch (IOException e) {
//     // TODO: handle exception
//     e.printStackTrace();
// }

