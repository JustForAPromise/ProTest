package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther fanhanxi
 * @Date 2018/12/25
 * @Description:
 */
public class ServerThread implements Runnable{

    private Socket client = null;
    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader readerSystem = new BufferedReader(new InputStreamReader(System.in));

            String message = null;

            while ((message = bufferedReader.readLine()) != null) {
                System.out.println("client：" + message);
                System.out.print("请输入：");
                message = readerSystem.readLine();
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            bufferedReader.close();
            bufferedWriter.close();
            readerSystem.close();
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
