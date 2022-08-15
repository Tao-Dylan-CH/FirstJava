package 第3部分._1网络编程._2TCP网络编程._1TCP1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/8 - 12 - 08 - 22:40
 * @Description 第3部分._2TCP字节编程._1TCP1
 * @Version 1.0
 */
public class TCP1Client {
    /*
    客户端
     */
    public static void main(String[] args) throws IOException {
        //1.获取端口对象  访问主机的9999号端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//主机+端口号
        System.out.println("客户端：" + socket.getClass());
        //2.由socket对象获取对应的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.向服务器发送数据
        outputStream.write("hello,service!".getBytes());
        //4.关闭流对象
        outputStream.close();
        //5.关闭端口
        socket.close();
        System.out.println("客户端退出...");
    }
}
