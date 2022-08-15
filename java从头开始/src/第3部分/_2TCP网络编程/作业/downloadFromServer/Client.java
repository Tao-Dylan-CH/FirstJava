package 第3部分._2TCP网络编程.作业.downloadFromServer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/12/11 - 12 - 11 - 9:56
 * @Description 第3部分._2TCP网络编程.作业.从服务器下载文件
 * @Version 1.0
 */
public class Client {
    /*
    客户端输入文件名，从服务器下载文件
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);
        String fileName;
        System.out.println("输入文件名：");
        fileName = scanner.next();
        //向服务器发送请求
        outputStream.write(fileName.getBytes());

        //下载到本地
        FileOutputStream fileOutputStream = new FileOutputStream("D:/temp/" + fileName);
        int dataLength;
        byte[] data = new byte[1024];
        while((dataLength = inputStream.read(data)) != -1){
            fileOutputStream.write(data, 0, dataLength);
        }
        System.out.println("下载完成! " + fileName);
        //输出结束
        socket.shutdownOutput();
        //关闭资源
        socket.close();
        inputStream.close();
        outputStream.close();
        fileOutputStream.close();
    }
}
