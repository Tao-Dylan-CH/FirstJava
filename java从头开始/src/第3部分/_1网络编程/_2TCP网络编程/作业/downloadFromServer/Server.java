package 第3部分._1网络编程._2TCP网络编程.作业.downloadFromServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/11 - 12 - 11 - 9:56
 * @Description 第3部分._1网络编程._2TCP网络编程.作业.从服务器下载文件
 * @Version 1.0
 */
public class Server {
    /*
    服务器接收客户端发送的文件名，传输文件到客户端
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端等待连接...");
        Socket socket = serverSocket.accept();
        System.out.println("连接成功...");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = null;

        //接收客户端请求
        byte[] data = new byte[1024];
        int dataLength = inputStream.read(data);
        String question = new String(data, 0, dataLength);
        //判断服务器是否有这个文件
        String directory = "src/";
        File file = new File(directory + question);
        String fileName;
        if(file.exists()){  //存在，传输此文件
            fileName = file.getAbsolutePath();
        }else{  //不存在,传输默认文件
            fileName = directory + "111.wav";
        }
        fileInputStream = new FileInputStream(fileName);
        while((dataLength = fileInputStream.read(data)) != -1){
            outputStream.write(data, 0, dataLength);
        }
        System.out.println("下载完成 " + fileName);
        //输出结束
        socket.shutdownOutput();
        //关闭资源
        serverSocket.close();
        socket.close();
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
    }
}
