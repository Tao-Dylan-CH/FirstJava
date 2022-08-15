package 第3部分._1网络编程._2TCP网络编程._2传输文件;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/9 - 12 - 09 - 22:24
 * @Description 第3部分._2TCP字节编程._2传输文件
 * @Version 1.0
 */
public class Client {
    /*
    客户端向服务器发送文件
     */
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8888);
            out = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream("E:/轻衣.png");
            int dataLength;
            byte[] data = new byte[1024];
            while((dataLength = fileInputStream.read(data)) != -1){
                out.write(data, 0, dataLength);
            }
            socket.shutdownOutput();    //写入结束标记，上传结束

            //接收服务器回复的消息
            InputStream in = socket.getInputStream();
            while((dataLength = in.read(data)) != -1){
                System.out.println(new String(data, 0, dataLength));
            }
            System.out.println("客服端退出...");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(socket != null){
                    socket.close();
                }
                if(out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
