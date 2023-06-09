/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author APC
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class ThreadSocket implements Runnable{
    private Socket socket;
    private Server main;
    private DataInputStream din;
    private String filename;
    private byte[] data;
    public ThreadSocket(Socket s, Server main){
        this.socket = s;
        this.main = main;

        try {
            din = new DataInputStream(socket.getInputStream());
            
        } catch (IOException e) {
            // TODO: handle exception
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
    @Override
    public void run(){
        try{

            while(true){
//                    if(main.getFlag_send()!=true){
//                        main.appendMessage("[Server]: "+main.getMessage());
//                        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
//                        dout.writeUTF(Encode_Rail_Fence(main.getMessage(),3));
//                        main.setFlag_send(true);
//                        main.setmsg_input("");
//                    }
                    String flag = din.readUTF();

    //                main.appendMessage(flag);
                    switch(flag){
                        case "_CHAT_":
    //                        main.appendMessage("client sent");
                            String msg = Decode_Rail_Fence(din.readUTF(),3);
//                            String msg = din.readUTF();

                            if(!msg.equals("Client Connected")){
                                main.appendMessage("[Client]: "+msg);
                                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                                dout.writeUTF(Encode_Rail_Fence(findSecondMostFrequentChar(msg),3));
                            }else{
                                main.appendMessage(msg);
                            }
                            break;
                        case "_SENDFILE_":
                            int fileNameLength = din.readInt();

                            if(fileNameLength > 0){
                                byte[] filenameByte = new byte[fileNameLength];  
                                din.readFully(filenameByte, 0, filenameByte.length);
                                String fileName1 = new String(filenameByte);
                                filename = fileName1;

                                int fileContentLength = din.readInt();

                                if(fileContentLength > 0){
                                    byte[] fileContentByte = new byte[fileContentLength];
                                    din.readFully(fileContentByte, 0, fileContentLength );
                                    data = fileContentByte;

                                }
                                LocalTime currentTime = LocalTime.now();

                            // Định dạng đối tượng LocalTime thành chuỗi ở định dạng "hh:mm:ss"
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                                String formattedTime = currentTime.format(formatter);
                                main.appendMessage("Client vừa gửi cho bạn 1 file:\t"+fileName1 + "\t" + formattedTime);
                                int result = JOptionPane.showConfirmDialog(main,"Bạn có chắc muốn lưu file này",
                            "Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                switch (result) {
                                    case JOptionPane.YES_OPTION:
                                        String path = "";
                                        JFileChooser chooser = new JFileChooser();
                                        chooser.setDialogTitle("Select a directory");
                                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                        int result_file = chooser.showOpenDialog(null);
                                        if (result_file == JFileChooser.APPROVE_OPTION) {
                                            File selectedDir = chooser.getSelectedFile();
                                            path = selectedDir.getAbsolutePath();
                                            System.out.println("Selected directory: " + path);

                                        }
                                        File filetoDownload = new File(path+"\\"+filename);
                                        try {
                                            FileOutputStream fileOutputStream = new FileOutputStream(filetoDownload);
                                            fileOutputStream.write(data);
                                            fileOutputStream.close();

                                            LocalTime currentTime1 = LocalTime.now();
                                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
                                            String formattedTime1 = currentTime1.format(formatter1);
                                            main.appendMessage("Download thành công file:\t"+filename + "\t" + formattedTime);
                                        } catch (IOException e) {
                                            // TODO: handle exception
                                            e.printStackTrace();
                                        }
                                        break;
                                    case JOptionPane.NO_OPTION:
                                        break;
                                    default:
                                        break;
                                }
                            }
                            break;
                    }
//               }else{

  //              }
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void send(){
        try {
            main.appendMessage("[Server]: "+main.getMessage());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(Encode_Rail_Fence(main.getMessage(),3));
            main.setFlag_send(true);
            main.setmsg_input("");
        } catch (IOException ex) {
        }
    }
}
