package 第3部分._1网络编程._2TCP网络编程._1TCP1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/8 - 12 - 08 - 22:35
 * @Description 第3部分._2TCP字节编程._1TCP1
 * @Version 1.0
 */
public class TCP1Server {
    /*
    服务端
     */
    public static void main(String[] args) throws IOException {
        //1.创建服务器端口对象
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待连接
        System.out.println("服务器监听9999端口，等待连接...");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功...");
        //3.接受请求
        InputStream inputStream = socket.getInputStream();
        byte[] data = new byte[1024];
        int dataLen ;
        while((dataLen = inputStream.read(data)) != -1){
            System.out.println(new String(data, 0, dataLen));
        }
        System.out.println("服务器socket:" + socket.getClass());
        //关闭流
        inputStream.close();
        //关闭接口
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出...");
    }
}
