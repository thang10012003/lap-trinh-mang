package TCP_UDP;
import java.io.*;
import java.net.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author APC
 */
public class TCP_Client {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try{
            String strsend ="";
            String strreceive = "";
            Socket socket = new Socket("localhost",8989);   
            System.out.println("Client is connected");   
            System.out.println("Nhap ten:");
            strsend = sc.nextLine();

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(strsend);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            strreceive = input.readUTF();
            System.out.println(strreceive);
            
        }catch(IOException e){
            System.out.print(e);
        }
    }

}
