package 第3部分._3UDP网络编程;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 挚爱之夕
 * @date 2021/12/10 - 12 - 10 - 15:31
 * @Description 第3部分._3UTP网络编程
 * @Version 1.0
 */
public class UDPReceiver {
    /*
    接收端也是发送端
    IP地址和端点是在创建数据报对象时指定的
     */
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象  监听9999端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //数据报最大64k
        byte[] data = new byte[1024];  //用于创建DatagramPacket对象
        //2.创建DatagramPacket用于接收数据
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        System.out.println("等待接收...");
        datagramSocket.receive(datagramPacket);
        //3.拆包
        int length = datagramPacket.getLength();    //实际接收数据长度
        data = datagramPacket.getData();            //数据
        System.out.println("收到消息：" + new String(data, 0, length));
        //4.回复消息
        data = "好的，明天见".getBytes();
        DatagramPacket datagramPacket1 =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9998);
        datagramSocket.send(datagramPacket1);
        System.out.println("发送消息：好的，明天见");
        //5.关闭
        datagramSocket.close();
        System.out.println("接收端退出...");
    }
}
