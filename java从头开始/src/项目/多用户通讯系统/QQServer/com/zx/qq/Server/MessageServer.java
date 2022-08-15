package 项目.多用户通讯系统.QQServer.com.zx.qq.Server;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * @author 挚爱之夕
 * @date 2021/12/15 - 12 - 15 - 21:58
 * @Description com.zx.qq.Server
 * @Version 1.0
 */
public class MessageServer {
    //日期格式化
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

    /**
     * 得到在线用户列表
     * @return  在线用户名空格分隔   用户1 用户2...
     */
    public static String onlineFriends(){
        return ManageClientThreads.getOnlineUsers();
    }

    /**
     * 向客户端返回在线用户列表
     * @param receiver    请求用户列表的用户ID
     */
    public static void retOnlineFriends(String receiver){
        Message message = new Message();
        //消息类型
        message.setMessageType(MessageType.MESSAGE_RET_ONLINE_FRIENDS);
        //消息内容
        message.setContent(onlineFriends());
        //发送时间
        message.setSendTime(formatter.format(LocalDateTime.now()));

//        //得到与请求用户连接的socket
//        Socket socket = ManageClientThreads.getServerConnectClientThread(receiver).getSocket();
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            //发送消息
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //方法重复部分，定义一个方法，提高代码重用性
        sendMessageToClient(receiver, message);
    }

    /**
     * 用户1发消息给用户2
     * 用户私聊功能中，服务器收到用户1的消息，发给用户2
     * @param message   消息
     */
    public static void privateMessage(Message message){
        String receiver = message.getReceiver();

//        //得到对应线程
//        ServerConnectClientThread serverConnectClientThread =
//                ManageClientThreads.getServerConnectClientThread(receiver);
//        //得到socket
//        Socket socket = serverConnectClientThread.getSocket();
//        try {
//            ObjectOutputStream oos =
//                    new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        sendMessageToClient(receiver, message);
    }

    /**
     * 用户群聊
     * @param sender 发起者ID
     * @param message   消息
     */
    public static void publicMessage(String sender, Message message){
        //得到所有在线用户对应的线程
        HashMap<String, ServerConnectClientThread> clientThreads
                = ManageClientThreads.getClientThreads();
        for(String id: clientThreads.keySet()){
            if(!id.equals(sender)){

//                ServerConnectClientThread serverConnectClientThread
//                        = clientThreads.get(id);
//                try {
//                    ObjectOutputStream oos =
//                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
//                    oos.writeObject(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                sendMessageToClient(id, message);
            }
        }
    }

    /**
     * 向用户发送文件
     * @param message 文件消息
     */
    public static void sendFileToReceiver(Message message){
        String receiver = message.getReceiver();

//        ServerConnectClientThread serverConnectClientThread =
//                ManageClientThreads.getServerConnectClientThread(receiver);
//        try {
//            ObjectOutputStream oos =
//                    new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        sendMessageToClient(receiver, message);
    }

    /**
     * 服务器向用户发送通知
     * @param content 消息内容
     * @param receiver  用户ID
     */
    public static void notice(String content, String receiver){
        Message message = new Message(content, "服务器", receiver,
                MessageType.MESSAGE_COMMON, formatter.format(LocalDateTime.now()));

//        ServerConnectClientThread serverConnectClientThread =
//                ManageClientThreads.getServerConnectClientThread(receiver);
//        Socket socket = serverConnectClientThread.getSocket();
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        sendMessageToClient(receiver, message);
    }

    /**
     * 服务端向用户端发送消息
     * @param receiver  用户ID
     * @param message   消息
     */
    public static void sendMessageToClient(String receiver, Message message){
        ServerConnectClientThread serverConnectClientThread =
                ManageClientThreads.getServerConnectClientThread(receiver);
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
