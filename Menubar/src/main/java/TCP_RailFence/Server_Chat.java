/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TCP_RailFence;

/**
 *
 * @author APC
 */
import java.io.*;
import java.net.*;
import java.util.*;
public class Server_Chat extends javax.swing.JFrame {

    /**
     * Creates new form Server
     */
    static ServerSocket server;
    static Socket socket;
    static DataInputStream data_input;
    static DataOutputStream data_output;
    public Server_Chat() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jText_msg = new javax.swing.JTextArea();
        msg_send = new javax.swing.JTextField();
        send_button = new javax.swing.JButton();
        end_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Chat");
        setLocation(new java.awt.Point(750, 0));

        jText_msg.setEditable(false);
        jText_msg.setColumns(20);
        jText_msg.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jText_msg.setRows(5);
        jScrollPane2.setViewportView(jText_msg);

        send_button.setText("Send");
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });

        end_button.setText("Close Server");
        end_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                end_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(msg_send))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(end_button))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(end_button, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    public static String findSecondMostFrequentChar(String str) {
        String msg = "";
        if (str == null || str.isEmpty()) {
            msg = "Không có kí tự nhiều thứ 2";
            return msg;
        }
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if(ch != ' '){
                charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
            }
        }
        int max = 0;
        int secondMax = 0;
        char result = 0;
        char preresult = 0;
        for (HashMap.Entry<Character, Integer> entry : charMap.entrySet()) {
            int value = entry.getValue();
            if (value > max) {
                secondMax = max;
                max = value;
                preresult = result;
                result = entry.getKey();
            } else if (value > secondMax && value < max) {
                preresult = entry.getKey();
                secondMax = value;
            }
        }
        if (secondMax == 0) {
            msg = "Không có kí tự nhiều thứ 2";
        } else {
            msg = "Kí tự nhiều thứ 2 là: " + preresult + " và xuất hiện: " + secondMax + " lần.";
        }
        return msg;
    }
    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        // TODO add your handling code here:
        
        try {
            String msg = "";
            msg = msg_send.getText().trim();
            String msg_encode = Encode_Rail_Fence(msg,3);
            data_output.writeUTF(msg_encode);
            jText_msg.setText(jText_msg.getText().trim() + "\n" + "Server Respond:  "+ msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg_send.setText("");


    }//GEN-LAST:event_send_buttonActionPerformed

    private void end_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_end_buttonActionPerformed
        // TODO add your handling code here:
        try {
            String msg = "";
            msg = "Server Disconnected.....";
            String msg_encode = Encode_Rail_Fence(msg,3);
            data_output.writeUTF(msg_encode);
            jText_msg.setText(jText_msg.getText().trim() + "\n" + "Disconnected Successfully!");
            socket.close();
            server.close();
        } catch (IOException e) {
        }
    }//GEN-LAST:event_end_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Server_Chat().setVisible(true);
        });

        String msg = "";
        try{
            server = new ServerSocket(5000);
            socket = server.accept();

            data_input = new DataInputStream(socket.getInputStream());
            data_output =  new DataOutputStream(socket.getOutputStream());
            while(true){
                msg = data_input.readUTF();
                String msg_decode = Decode_Rail_Fence(msg,3);

                if(!msg.equals("")){
                    if(msg.equals("Client has disconnected!")){
                        jText_msg.setText(jText_msg.getText().trim() + "\n"+ msg_decode);
                    }else{
                        jText_msg.setText(jText_msg.getText().trim() + "\n" + "Client:  "+ msg_decode);
                        try {
                            String msg_encode = Encode_Rail_Fence(findSecondMostFrequentChar(msg_decode),3);
                            data_output.writeUTF(msg_encode);
                            jText_msg.setText(jText_msg.getText().trim() + "\n" + "Server Respond:  "+ findSecondMostFrequentChar(msg_decode));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        
//                        jText_msg.setText(jText_msg.getText().trim() + "\n" + "Client:  "+ msg);
                    }

                }
            }
            
        }catch(IOException e){
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton end_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea jText_msg;
    private javax.swing.JTextField msg_send;
    private javax.swing.JButton send_button;
    // End of variables declaration//GEN-END:variables
}
