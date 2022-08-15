package 项目.多用户通讯系统.QQServer.com.zx.qq.Server;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 13:31
 * @Description 项目.多用户通讯系统.Server.Server
 * @Version 1.0
 * 该类管理与客户端通讯的线程
 */
public class ManageClientThreads {
    private static final HashMap<String, ServerConnectClientThread> map = new HashMap<>();
    public static void addServerConnectClientThread(String id, ServerConnectClientThread serverConnectClientThread){
        map.put(id, serverConnectClientThread);
    }
    public static ServerConnectClientThread getServerConnectClientThread(String id){
        return map.get(id);
    }
    public static HashMap<String, ServerConnectClientThread> getClientThreads(){
        return map;
    }
    //返回在线用户ID
    public static String getOnlineUsers(){
        Set<String> users = map.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (String user:users
             ) {
            stringBuilder.append(user).append(" ");
        }
        return stringBuilder.toString();
    }
    public static void removeUser(String id){
        map.remove(id);
    }
}
