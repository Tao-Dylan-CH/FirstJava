package 第3部分._1网络编程._2TCP网络编程._1TCP3字符流;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/9 - 12 - 09 - 10:04
 * @Description 第3部分._2TCP字节编程._1TCP3字符流
 * @Version 1.0
 */
public class TCP3Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        //转换流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write("I'm client, hello server!");
        writer.newLine();   //插入一个换行符，表示一行结束, 要求对方使用readLine()
        writer.flush(); //使用字符流需要手动刷新，否则不会写入
        socket.shutdownOutput();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println(reader.readLine());

        //关闭
        socket.close();
        reader.close(); //关闭外层流
        writer.close();
        System.out.println("客户端退出...");
    }
}
