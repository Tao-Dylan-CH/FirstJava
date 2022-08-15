package 第3部分._2TCP网络编程._2传输文件;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/9 - 12 - 09 - 22:24
 * @Description 第3部分._2TCP字节编程._2传输文件
 * @Version 1.0
 */
public class Server {
    /*
    服务器收到文件返回信息
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器等待连接...");
            socket = serverSocket.accept();
            in = socket.getInputStream();
            out = socket.getOutputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("src/轻衣.png");
            int dataLength;
            byte[] data = new byte[1024];
            while((dataLength = in.read(data)) != -1){
                fileOutputStream.write(data, 0, dataLength);
            }
            out.write("收到文件...".getBytes());
            socket.shutdownOutput();
            System.out.println("服务器退出...");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
