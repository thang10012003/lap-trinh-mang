
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author APC
 */
import java.io.*;
import java.net.*;
public class ClientThread implements Runnable{
    private DataInputStream din ;
    private DataOutputStream dout;
    private Socket socket;
    private Client main;

    public ClientThread(Socket s, Client main){
        try {
            this.socket = s;
            this.main = main;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    @Override
    public void run(){
        String msg = "";
        try {
            din = new DataInputStream(socket.getInputStream());
            
            while(true){
                msg = din.readUTF();
                msg = Decode_Rail_Fence(msg,3);
                // String msg_decode = Decode_Rail_Fence(msg,3);
//                if(!msg.equals("")){
//                    if(msg.equals("Server Disconnected.....")){
//                        // jText_msg.setText(jText_msg.getText().trim() + "\n"+msg_decode);
//                    }else{
//    //                        jText_msg.setText(jText_msg.getText().trim() + "\n" + "Server:  "+msg_decode);     
//                        // jText_msg.setText(jText_msg.getText().trim() + "\n" + "Server:  "+msg_decode); 
//                        main.appendMessage(msg);
//                    }
//                }
                main.appendMessage("[Server]: "+msg);
            }
        }catch(IOException e){
            main.appendMessage(e.getMessage());
            main.showdialog_warning(e.getMessage());
        }
    }
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
}
