package 项目.多用户通讯系统.QQServer.com.zx.qq.Server;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;
import 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * @author 挚爱之夕
 * @date 2021/12/15 - 12 - 15 - 21:20
 * @Description com.zx.qq.Server
 * @Version 1.0
 */
public class SendNewsToClients extends Thread{
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        while(true){
            System.out.println("输入向客户端推送的消息：");
            System.out.println("输入exit，退出服务器");
            String news = Utility.readString(200);
            if(news.equals("exit")){
                QQServer.terminateQQServer();
                break;
            }
            Message message = new Message();
            message.setMessageType(MessageType.MESSAGE_NOTICE);
            message.setContent(news);
            message.setSendTime(formatter.format(LocalDateTime.now()));
            HashMap<String, ServerConnectClientThread> clientThreads =
                    ManageClientThreads.getClientThreads();
            //向每个在线用户，发送推文
            for(ServerConnectClientThread thread: clientThreads.values()){
                Socket socket = thread.getSocket();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
