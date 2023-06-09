import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author nguyenan
 */
public class Client extends javax.swing.JFrame  {

    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
    }
    private Socket socket = null;
    private String ip = "";
    private int port ;
    private String name = "";
    private DataOutputStream dout = null;
    private Thread t;
    private ClientThread client;
    private File[] filetosend = new File[1];

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputName = new java.awt.TextField();
        inputIP = new java.awt.TextField();
        inputPort = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_output = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg_input = new javax.swing.JTextArea();
        send_btn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Connect_btn = new javax.swing.JButton();
        jText_FileName = new javax.swing.JTextField();
        ChooseFile_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("IP");

        jLabel3.setText("Port");

        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });

        inputIP.setText("127.0.0.1");

        inputPort.setText("33");
        inputPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPortActionPerformed(evt);
            }
        });

        msg_output.setColumns(20);
        msg_output.setRows(5);
        jScrollPane1.setViewportView(msg_output);

        msg_input.setColumns(20);
        msg_input.setRows(5);
        jScrollPane2.setViewportView(msg_input);

        send_btn.setText("Send");
        send_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_btnActionPerformed(evt);
            }
        });

        jButton3.setText("Send File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Connect_btn.setText("Connect");
        Connect_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Connect_btnActionPerformed(evt);
            }
        });

        ChooseFile_btn.setText("Choose a file to send");
        ChooseFile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFile_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(inputIP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(inputPort, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(Connect_btn)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jText_FileName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ChooseFile_btn))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(send_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(inputIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))))
                    .addComponent(Connect_btn))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText_FileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChooseFile_btn))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("name");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameActionPerformed

    private void inputPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPortActionPerformed
    public static String Encode_Rail_Fence(String s, int key){
        int row = key;
        int col = s.length();
        char[][] arr = new char[row][col];
        String output="";
        int j = 0;
        boolean check = false;
        for(int i = 0; i < col; i++){
            if(j == 0 || j== key - 1){
                check = !check;
            }
            arr[j][i] = s.charAt(i);
            if(check){
                j++;
            }else{
                j--;
            }
        }
        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(arr[i][k] != 0){
                    output += arr[i][k];
                }
            }
        }
        return output;
    }
    
    //Decode Message
    public static String Decode_Rail_Fence(String s, int key){
        int row = key;
        int col = s.length();
        char[][] arr = new char[row][col];
        String output="";
        int j = 0;
        boolean check = false;
        for(int i = 0; i < col; i++){
            if(j == 0 || j== key - 1){
                check = !check;
            }
            arr[j][i] = '*';
            if(check){
                j++;
            }else{
                j--;
            }
        }
        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(arr[i][k]!='*'){
                    arr[i][k] = '-';
                }
            }
        }
        int index = 0;
        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(arr[i][k]=='*'){
                    arr[i][k] = s.charAt(index++);
                }
            }
        }
        j = 0;
        check = false;
        for(int i = 0; i < col; i++){
            if(j == 0 || j== key - 1){
                check = !check;
            }
            output += arr[j][i];
            if(check){
                j++;
            }else{
                j--;
            }
        }
        
        return output;
    }
    private void send_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_btnActionPerformed
        // TODO add your handling code here:
        try{
            if(!msg_input.getText().equals("")){
                dout.writeUTF("_CHAT_");
                dout.writeUTF(Encode_Rail_Fence(msg_input.getText(),3));
                msg_input.setText("");
            }

        }catch(Exception e){
            
        }
    }//GEN-LAST:event_send_btnActionPerformed

    private void Connect_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Connect_btnActionPerformed
        ip = inputIP.getText();
        port = Integer.parseInt(inputPort.getText());
        try {
            // TODO add your handling code here:
            socket = new Socket(ip, port);
            appendMessage("Connected Successfully");
            dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF("_CHAT_");
            dout.writeUTF(Encode_Rail_Fence("Client Connected",3));
            client = new ClientThread(socket, this);
            t = new Thread(client);
            t.start();
        } catch (IOException ex) {
            appendMessage("[IOException]: "+ex.getMessage());
        }
        
    }//GEN-LAST:event_Connect_btnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(filetosend[0] == null){
            showdialog_warning("You need to choose a file to send first");
        }else{
            try{
                FileInputStream fileinput = new FileInputStream(filetosend[0].getAbsolutePath());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String filename = filetosend[0].getName();
                byte[] filenameByte = filename.getBytes();

                byte[] fileContentByte = new byte[(int) filetosend[0].length()];
                fileinput.read(fileContentByte);

                dataOutputStream.writeUTF("_SENDFILE_");
                dataOutputStream.writeInt(filenameByte.length);
                dataOutputStream.write(filenameByte);

                dataOutputStream.writeInt(fileContentByte.length);
                dataOutputStream.write(fileContentByte);
            

            
            }catch(IOException e){
                e.printStackTrace();
            }
            showdialog_warning("Successful");
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void ChooseFile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFile_btnActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Choose a file to send");
        
        if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            filetosend[0] = filechooser.getSelectedFile();
            jText_FileName.setText(filetosend[0].getName());
        }else{
            jText_FileName.setText("");
        }
    }//GEN-LAST:event_ChooseFile_btnActionPerformed


    void appendMessage(String s){
        msg_output.setText(msg_output.getText().trim()+"\n"+s);
    }
    void showdialog_warning(String s){

        JOptionPane.showMessageDialog(this,s,"Warning",JOptionPane.INFORMATION_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Client client = new Client();
                    client.setVisible(true);
                } catch (Exception e) {
                    //TODO: handle exception
                    e.printStackTrace();
                }
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseFile_btn;
    private javax.swing.JButton Connect_btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private java.awt.TextField inputIP;
    private java.awt.TextField inputName;
    private java.awt.TextField inputPort;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jText_FileName;
    private javax.swing.JTextArea msg_input;
    private javax.swing.JTextArea msg_output;
    private javax.swing.JButton send_btn;
    // End of variables declaration//GEN-END:variables
}


//        try {
//            // Get input data including name, IP, and port
//            name = inputName.getText();
//            ip = inputIP.getText();
//            port = Integer.parseInt(inputPort.getText());
//
//            // Create a new socket using the provided IP and port
//            try {  
//                socket = new Socket(ip, port);
//                bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                os = new DataOutputStream(socket.getOutputStream());
//                os.writeBytes(name + "\n");
//                os.flush();
//        // display successful connection message
//                JOptionPane.showMessageDialog(this, "Connected to server!");
//            } catch (Exception e) {
//                //TODO: handle exception
//                JOptionPane.showMessageDialog(this, "Connection failed: " + e.getMessage());
//            }
//
//            // Check if the socket is connected
//            if (!socket.isConnected()) {
//                throw new Exception("Could not connect to server");
//            }
//
//            // Check if the name is empty
//            if(name.isEmpty()) {
//                throw new Exception("Empty Name");
//            }
//            if (jTabbedPane1.getTabCount() > 0) {
//                jTabbedPane1.removeAll();
//            }
//
//            ChatPanel chatPanel = new ChatPanel(socket, name, "Manager");
//            jTabbedPane1.add(chatPanel);
//            jTabbedPane1.updateUI();
//
//
//            // Start a new thread for the chat panel
//            Thread t=new Thread(chatPanel);
//            t.start();
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Invalid port number", "Error", JOptionPane.ERROR_MESSAGE);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
