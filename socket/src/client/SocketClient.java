package client;

import java.io.*;
import java.net.Socket;

/**
 * @Auther fanhanxi
 * @Date 2018/12/25
 * @Description:
 */
public class SocketClient {
    private void createClient() {
        String hostIp = "127.0.0.1";
        int port = 9596;
        Socket client = null;
        try {
            client = new Socket(hostIp, port);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader readerSystem = new BufferedReader(new InputStreamReader(System.in));

            String message = null;
            System.out.print("请输入：");
            message = readerSystem.readLine();
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            while ( (message = bufferedReader.readLine()) != null) {
                System.out.println("server：" + message);
                System.out.print("请输入：");
                message = readerSystem.readLine();
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            bufferedWriter.close();
            bufferedReader.close();
            readerSystem.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.createClient();
    }
}
