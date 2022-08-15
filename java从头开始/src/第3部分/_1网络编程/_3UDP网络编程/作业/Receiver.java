package 第3部分._1网络编程._3UDP网络编程.作业;

import java.io.IOException;
import java.net.*;

/**
 * @author 挚爱之夕
 * @date 2021/12/11 - 12 - 11 - 9:32
 * @Description 第3部分._1网络编程._3UDP网络编程.作业
 * @Version 1.0
 */
public class Receiver {
    /*
    (1) 编写一个接收端和一个发送端
    (2) 接收端在 8888 端口等待接收数据(receive)
    (3) 发送端向接收端 发送 数据 "四大名著是哪些"
    (4) 接收端接收到 发送端发送的问题后，返回 "四大名著是<<红楼梦>: .."，否则返回 什么？
    (5)接收端和发送端退出
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        //接收
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        data = datagramPacket.getData();
        if(new String(data, 0, length).equals("四大名著是哪些")){
            data = "四大名著是《红楼梦》、《西游记》、《水浒传》、《三国演义》".getBytes();
        }else{
            data = "什么？".getBytes();
        }
        //发送
        datagramSocket.send(new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8888));
        //关闭
        datagramSocket.close();
    }
}
