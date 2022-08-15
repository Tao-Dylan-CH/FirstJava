package 项目.多用户通讯系统.QQServer.com.zx.qq.Server;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 13:18
 * @Description 项目.多用户通讯系统.Server.Server
 * @Version 1.0
 */
public class ServerConnectClientThread extends Thread{
    private final Socket socket;
    private final String userId;
//    //日期格式化
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        label:
        while(true){
            try {
                System.out.println("服务端与用户 "+userId+" 保持数据连接...");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                switch (message.getMessageType()) {
                    case MessageType.MESSAGE_GET_ONLINE_FRIENDS:
                        System.out.println("用户 " + userId + " 请求获取在线用户列表...");
                        //向请求用户，发送消息
                        MessageServer.retOnlineFriends(message.getSender());
                        break;
                    case MessageType.MESSAGE_Client_EXIT:
                        //移除退出用户
                        ManageClientThreads.removeUser(userId);
                        socket.close();
                        System.out.println("用户 " + userId + " 下线...");
                        break label;
                    case MessageType.MESSAGE_COMMON:
                        //得到接收者
                        String receiver = message.getReceiver();
                        //判断用户是否在线
                        if (ManageClientThreads.getServerConnectClientThread(receiver) != null) {
                            //服务器作为中转，向接收者转发消息
                            MessageServer.privateMessage(message);
                            System.out.println(message.getSender() + " 向 " +
                                    message.getReceiver() + "发送了消息...");
                        } else if(QQServer.isValidUser(receiver)){//用户不在线
                            String content = "用户 " + message.getReceiver() + " 不在线";
                            MessageServer.notice(content, message.getSender());
                            OfflineServer.addOfflineMessage(receiver, message);
                        } else{ //用户名非法
                            String content = "用户 " + message.getReceiver() + " 不存在";
                            MessageServer.notice(content, message.getSender());
                        }
                        break;
                    case MessageType.MESSAGE_TO_ALL:
                        String sender = message.getSender();
                        MessageServer.publicMessage(sender, message);
                        System.out.println("用户 " + message.getSender() + " 发送了群发消息...");
                        break ;
                    case MessageType.MESSAGE_FILE:
                        receiver = message.getReceiver();
                        //判断用户是否在线
                        if (ManageClientThreads.getServerConnectClientThread(receiver) != null) {
                            //服务器作为中转，向接收者转发消息
                            MessageServer.sendFileToReceiver(message);
                            System.out.println(message.getSender() + " 向 " +
                                    message.getReceiver() + " 发送了文件...");
                        } else if(QQServer.isValidUser(receiver)){  //用户不在线
                            String content = "用户 " + message.getReceiver() + " 不在线";
                            MessageServer.notice(content, message.getSender());
                            OfflineServer.addOfflineMessage(receiver, message);
                        } else{ //用户名非法
                            String content = "用户 " + message.getReceiver() + " 不存在";
                            MessageServer.notice(content, message.getSender());
                        }
                        break ;

                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public ServerConnectClientThread(String userId, Socket socket){
        this.userId = userId;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getUserId() {
        return userId;
    }

    // 移到了MessageServer里
//    //得到在线用户列表
//    public static String onlineFriends(){
//        return ManageClientThreads.getOnlineUsers();
//    }
//    //向客户端返回在线用户列表
//    public void retOnlineFriends(){
//        Message message = new Message();
//        message.setMessageType(MessageType.MESSAGE_RET_ONLINE_FRIENDS);
//        message.setContent(onlineFriends());
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    //用户私聊
//    public static void privateMessage(Message message){
//        String receiver = message.getReceiver();
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
//    }
//    //服务器向用户发送通知
//    public void notice(String content, String receiver){
//
//        Message message = new Message(content, "服务器", receiver,
//                MessageType.MESSAGE_COMMON, formatter.format(LocalDateTime.now()));
//        ServerConnectClientThread serverConnectClientThread =
//                ManageClientThreads.getServerConnectClientThread(receiver);
//        Socket socket = serverConnectClientThread.getSocket();
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    //用户群聊
//    public void publicMessage(String sender, Message message){
//        //得到所有在线用户对应的线程
//        HashMap<String, ServerConnectClientThread> clientThreads
//                = ManageClientThreads.getClientThreads();
//        for(String id: clientThreads.keySet()){
//            if(!id.equals(sender)){
//                ServerConnectClientThread serverConnectClientThread
//                        = clientThreads.get(id);
//                try {
//                    ObjectOutputStream oos =
//                            new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
//                    oos.writeObject(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//    //向用户发送文件
//    public static void sendFileToReceiver(Message message){
//        String receiver = message.getReceiver();
//        ServerConnectClientThread serverConnectClientThread =
//                ManageClientThreads.getServerConnectClientThread(receiver);
//        try {
//            ObjectOutputStream oos =
//                    new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
