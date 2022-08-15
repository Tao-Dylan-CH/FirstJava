package 第3部分._2TCP网络编程.作业;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/12/11 - 12 - 11 - 8:53
 * @Description 第3部分._2TCP网络编程.作业
 * @Version 1.0
 */
public class Client {
    /*
    (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
    (2) 客户端发送 "name"，服务器端接收到后，返回“我是 nova " nova 是你自己的名字.
    (3) 客户端发送 "hobby"，服务器端接收到后， ，返回“编写java程序"
    (4)不是这两个问题，回复“你说啥呢”
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter your question,输入0退出：");
            String question = scanner.next();
            if(question.equals("0")){
                break;
            }
            writer.write(question);
            writer.newLine();
            writer.flush(); //字符流，手动刷新

            String s = reader.readLine();
            System.out.println(s);
        }


        socket.shutdownOutput();    //最后关闭一次

        socket.close();
        reader.close();
        writer.close();
    }
}
