/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author APC
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ThreadServer implements Runnable{
    ServerSocket server;
    Server main;
    boolean keepGoing = true;
    ThreadSocket threadsocket;
    
    public ThreadServer(int port, Server main){
        try {
            this.main = main;
            server = new ServerSocket(port);
            main.appendMessage("Server connected port "+port + "!");
        } 
        catch (IOException e) { main.appendMessage("[IOException]: "+ e.getMessage()); }
    }

    @Override
    public void run() {
        try {
            while(keepGoing){
                Socket socket = server.accept();
                
                /** SOcket thread **/
                threadsocket = new ThreadSocket(socket, main);
                new Thread(threadsocket).start();
            }
        } catch (IOException e) {
            main.appendMessage("[ServerThreadIOException]: "+ e.getMessage());
        }
    }
    
    
    public void stop(){
        try {
            server.close();
            keepGoing = false;
            main.appendMessage("Máy Chủ bị đóng..!");
            System.exit(0);
        } catch (IOException e) {
//            System.out.println(e.getMessage());
        }
    }
    public void send(){
        threadsocket.send();
    }
    
}

