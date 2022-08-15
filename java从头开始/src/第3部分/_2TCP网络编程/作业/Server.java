package 第3部分._2TCP网络编程.作业;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/11 - 12 - 11 - 8:52
 * @Description 第3部分._2TCP网络编程.作业
 * @Version 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        while(true){
            String s = reader.readLine();
            if(s == null){
                break;
            }
            if(s.equals("name")){
                writer.write("I'm ron.");
            }else if(s.equals("hobby")){
                writer.write("I like play wizard chess.");
            }else{
                writer.write("What you mean?");
            }
            writer.newLine();
            writer.flush();
        }

        socket.shutdownOutput();

        serverSocket.close();
        socket.close();
        reader.close();
        writer.close();
    }
}
