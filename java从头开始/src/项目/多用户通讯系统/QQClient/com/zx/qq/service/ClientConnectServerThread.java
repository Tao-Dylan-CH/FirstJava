package 项目.多用户通讯系统.QQClient.com.zx.qq.service;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;

import java.io.*;
import java.net.Socket;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 12:18
 * @Description 项目.多用户通讯系统.Client.service
 * @Version 1.0
 * 客户端线程
 */
public class ClientConnectServerThread extends Thread{
    private final Socket socket;

    @Override
    public void run() {
        //需要在后台和服务器保持通讯，需要使用while循环
        while(true){
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //当服务器没有返回消息，线程会阻塞在此
//                System.out.println("等待服务器响应...");
                项目.多用户通讯系统.QQClient.com.zx.qq.common.Message message = (Message) ois.readObject();
                //接收消息
                switch (message.getMessageType()) {
                    case MessageType.MESSAGE_RET_ONLINE_FRIENDS:
                        System.out.println("\n" + message.getSendTime());
                        String[] onlineFriends = message.getContent().split(" ");
                        System.out.println("-----在线用户列表-----");
                        for (String onlineFriend : onlineFriends
                        ) {
                            System.out.println("用户ID: " + onlineFriend);
                        }
                        break;
                    case MessageType.MESSAGE_COMMON:
                    case MessageType.MESSAGE_TO_ALL:
                        System.out.println("\n" + message.getSendTime());
                        System.out.println("来自 " + message.getSender() + " 的消息:");
                        System.out.println(message.getContent());
                        break;
                    case MessageType.MESSAGE_FILE:
                        FileClientService.saveFile(message);
                        System.out.println("\n" + message.getSendTime());
                        System.out.println("收到来自 " + message.getSender() + " 的文件:");
                        System.out.println(FileClientService.saveFileDirectory + " " + message.getFileName());
                        break;
                    case MessageType.MESSAGE_NOTICE:
                        System.out.println("\n" + message.getSendTime());
                        System.out.println("来自服务器的通知：");
                        System.out.println(message.getContent());
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

}
