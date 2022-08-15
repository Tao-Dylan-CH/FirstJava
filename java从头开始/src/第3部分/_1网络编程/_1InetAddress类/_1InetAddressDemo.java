package 第3部分._1网络编程._1InetAddress类;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 挚爱之夕
 * @date 2021/12/8 - 12 - 08 - 10:35
 * @Description 第3部分._1网络编程._1InetAddress类
 * @Version 1.0
 */
public class _1InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //1.获取本机 InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//LAPTOP-GIK86SC8/172.27.144.1
        //2.根据名称获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("LAPTOP-GIK86SC8");
        System.out.println(host1);
        //3.根据域名获取 InetAddress对象
        InetAddress host = InetAddress.getByName("www.baidu.com");
        System.out.println(host);//www.baidu.com/36.152.44.96

        //3.根据对象获取名称
        String host1Name = host1.getHostName();
        System.out.println("host1 name:" + host1Name);//host1 name:LAPTOP-GIK86SC8
        //4.根据对象获取地址
        String hostAddress = host1.getHostAddress();
        System.out.println("host1 address:" + hostAddress);//host1 address:192.168.137.1
    }
}
