package 项目.多用户通讯系统.QQClient.com.zx.qq.service;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 挚爱之夕
 * @date 2021/12/14 - 12 - 14 - 22:32
 * @Description com.zx.qq.service
 * @Version 1.0
 * 该类提供和信息相关的功能
 */
public class MessageClientService {
    //时期格式化
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
     * 私发消息
     * @param sender 发送者
     * @param receiver 接收者
     * @param content   消息内容
     */
    public void sendPrivateMessage(String sender, String receiver, String content){

        String now = formatter.format(LocalDateTime.now());
        项目.多用户通讯系统.QQClient.com.zx.qq.common.Message message =
                new 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message(content, sender, receiver,
                        MessageType.MESSAGE_COMMON, now);
        //得到当前线程
        ClientConnectServerThread clientConnectServerThread =
                ManageClientConnectServerThread.getClientConnectServerThread(sender);
        //得到socket
        Socket socket = clientConnectServerThread.getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 群发消息
     * @param sender 发送者
     * @param content   消息内容
     */
    public void sendPublicMessage(String sender, String content){
        项目.多用户通讯系统.QQClient.com.zx.qq.common.Message message = new Message();
        message.setSender(sender);
        message.setMessageType(MessageType.MESSAGE_TO_ALL);
        message.setContent(content);
        message.setSendTime(formatter.format(LocalDateTime.now()));
        ClientConnectServerThread clientConnectServerThread =
                ManageClientConnectServerThread.getClientConnectServerThread(sender);
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(clientConnectServerThread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
