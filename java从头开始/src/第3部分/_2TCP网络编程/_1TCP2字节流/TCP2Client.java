package 第3部分._2TCP网络编程._1TCP2字节流;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/9 - 12 - 09 - 9:42
 * @Description 第3部分._2TCP字节编程._1TCP2
 * @Version 1.0
 */
public class TCP2Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        System.out.println("客户端连接到服务器...");
        outputStream.write("hello, Server!".getBytes());
        socket.shutdownOutput();    //注意：输出结束标记
        byte[] data = new byte[1024];
        int dataLength;
        System.out.println("得到数据：");
        while((dataLength = inputStream.read(data)) != -1){
            System.out.println(new String(data, 0, dataLength));
        }
        socket.close();
        inputStream.close();
        outputStream.close();
        System.out.println("客户端退出...");
    }
}
