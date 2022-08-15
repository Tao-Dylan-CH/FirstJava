package 项目.多用户通讯系统.QQServer.com.zx.qq.Server;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 挚爱之夕
 * @date 2021/12/15 - 12 - 15 - 21:47
 * @Description com.zx.qq.Server
 * @Version 1.0
 * 为用户提供离线消息功能
 */
public class OfflineServer {
    //存储用户的离线消息
    private static final ConcurrentHashMap<String, ArrayList<Message>>
            offlineLibrary = new ConcurrentHashMap<>();

    /**
     * 用户登录时，检查用户是否有离线消息
     * 有则发送
     * @param id 用户ID
     */
    public static void check(String id){
        ArrayList<Message> messages = offlineLibrary.get(id);
        if(messages == null){   //没有离线消息
            return;
        }
        //发送离线消息
        for (Message message:messages
             ) {
            //消息类型
            String messageType = message.getMessageType();
            if(messageType.equals(MessageType.MESSAGE_COMMON)){//私发消息
                MessageServer.privateMessage(message);
            }else if(messageType.equals(MessageType.MESSAGE_FILE)){ //文件
                MessageServer.sendFileToReceiver(message);
            }
        }
    }
    public static void addOfflineMessage(String id, Message message){
        offlineLibrary.computeIfAbsent(id, k -> new ArrayList<>());
        offlineLibrary.get(id).add(message);
    }
}
