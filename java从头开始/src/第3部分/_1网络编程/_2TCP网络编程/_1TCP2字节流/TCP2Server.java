package 第3部分._1网络编程._2TCP网络编程._1TCP2字节流;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/9 - 12 - 09 - 9:42
 * @Description 第3部分._2TCP字节编程._1TCP2
 * @Version 1.0
 */
public class TCP2Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket( 9999);
        System.out.println("服务器等待连接...");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("连接成功...");
        byte[] data = new byte[1024];
        int dataLength;
        //读入请求
        while((dataLength = inputStream.read(data)) != -1){
            System.out.println(new String(data, 0, dataLength));
        }
        //返回数据
        outputStream.write("hello, client!".getBytes());//注意：输出结束标记
        socket.shutdownOutput();
        serverSocket.close();
        socket.close();
        inputStream.close();
        outputStream.close();
        System.out.println("服务器退出...");
    }
}
