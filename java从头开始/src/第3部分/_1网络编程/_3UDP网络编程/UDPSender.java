package 第3部分._1网络编程._3UDP网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 挚爱之夕
 * @date 2021/12/10 - 12 - 10 - 15:33
 * @Description 第3部分._1网络编程._3UDP网络编程
 * @Version 1.0
 */
public class UDPSender {
    /*
    发送端也是接收端
     */
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象，指定端口，也可以做接收端
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        byte[] data = "明天吃火锅".getBytes();
        //2.创建数据报，指定主机地址和端口
        DatagramPacket datagramPacket =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        //3.发送数据
        datagramSocket.send(datagramPacket);
        System.out.println("发送消息：明天吃火锅");
        //4.接收回复
        datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);
        //5.打印消息
        int length = datagramPacket.getLength();    //实际接收数据长度
        data = datagramPacket.getData();
        System.out.println("收到消息：" + new String(data, 0, length));
        //6.关闭
        datagramSocket.close();
        System.out.println("发送端退出...");
    }
}
