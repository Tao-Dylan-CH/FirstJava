package 第3部分._3UDP网络编程.作业;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 挚爱之夕
 * @date 2021/12/11 - 12 - 11 - 9:32
 * @Description 第3部分._3UDP网络编程.作业
 * @Version 1.0
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        //发送
        byte[] data = "四大名著是哪些".getBytes();
        datagramSocket.send(new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999));

        //接收
        data = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        data = datagramPacket.getData();
        System.out.println(new String(data, 0, length));

        datagramSocket.close();
    }
}
