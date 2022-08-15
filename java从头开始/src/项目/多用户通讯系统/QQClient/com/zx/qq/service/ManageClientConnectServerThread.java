package 项目.多用户通讯系统.QQClient.com.zx.qq.service;

import java.util.HashMap;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 12:43
 * @Description 项目.多用户通讯系统.Client.service
 * @Version 1.0
 * 管理客户端线程的类
 */
public class ManageClientConnectServerThread {
    private static final HashMap<String, ClientConnectServerThread> map = new HashMap<>();

    public static void addClientConnectServerThread(String id, ClientConnectServerThread clientConnectServerThread){
        map.put(id, clientConnectServerThread);
    }
    public static ClientConnectServerThread getClientConnectServerThread(String id){
        return map.get(id);
    }
}
