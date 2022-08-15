package 第3部分._1网络编程._2TCP网络编程._1TCP3字符流;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/9 - 12 - 09 - 10:05
 * @Description 第3部分._2TCP字节编程._1TCP3字符流
 * @Version 1.0
 */
public class TCP3Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器监听9999端口，等待连接...");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功...");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        //转换流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //字节输入流转字符输入流
        //读入数据
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println(reader.readLine());
        //字节输出流转字符字节输出流
        //写出数据
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter writer = new BufferedWriter(outputStreamWriter);
        writer.write("I'm server, hello Client!");
        writer.newLine();   //插入一个换行符,表示一行结束，要求对方使用readLine()
        writer.flush(); //使用字符流需要手动刷新，否则不会写入
        socket.shutdownOutput();

        serverSocket.close();
        socket.close();
        reader.close(); ////关闭外层流
        writer.close();
        System.out.println("服务端退出...");
    }
}
