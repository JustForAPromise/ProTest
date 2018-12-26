package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther fanhanxi
 * @Date 2018/12/25
 * @Description:
 */
public class SocketServers {

    private void createServer(){
        int port = 9596;
        try{
            ServerSocket server =  new ServerSocket(port);
            Socket client = null;
            while (true){
                client = server.accept();
                System.out.println("success");

                new Thread(new ServerThread(client)).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        SocketServers server = new SocketServers();
        server.createServer();
    }
}
