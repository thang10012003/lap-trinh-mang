package TCP_UDP;

import java.net.*;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author APC
 */
public class TCP_Server {
    public static void main(String args[]){
        try{
            String strreceive = "";
            String strsend = "";
            ServerSocket serversocket = new ServerSocket(8989);
            Socket s = serversocket.accept();
        
            DataInputStream input = new DataInputStream(s.getInputStream());
            strreceive = input.readUTF();
            System.out.println(strreceive);
           
        }catch(IOException e){
            System.out.println(e);
        }

    }
}
