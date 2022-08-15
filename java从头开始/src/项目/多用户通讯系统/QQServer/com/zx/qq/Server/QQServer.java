package 项目.多用户通讯系统.QQServer.com.zx.qq.Server;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 13:00
 * @Description 项目.多用户通讯系统.Server.Server
 * @Version 1.0
 */
public class QQServer {
    private static ServerSocket serverSocket;
    //存储合法用户信息
    private static final ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    private static boolean loop = true;
    static {    //加载类时，初始化合法用户信息
        validUsers.put("111", new User("111", "12345"));
        validUsers.put("3402747477", new User("3402747477", "12345"));
        validUsers.put("至尊宝", new User("至尊宝", "12345"));
        validUsers.put("紫霞仙子", new User("紫霞仙子", "12345"));
        validUsers.put("诸葛罗心", new User("诸葛罗心", "12345"));
    }
    private boolean checkUser(String id, String password){
        User user = validUsers.get(id);
        if(user == null){   //用户不存在
            return false;
        }
        //用户存在
        return user.getPassword().equals(password);
    }

    /**
     * 判断用户名是否合法
     * @param name  用户名
     * @return  用户名合法返回true
     */
    public static boolean isValidUser(String name){
        for (String id:validUsers.keySet()
             ) {
            if(name.equals(id)){
                return true;
            }
        }
        return false;
    }
    public QQServer() {
        new SendNewsToClients().start();
        try {
            serverSocket = new ServerSocket(9999);
            System.out.println("等待用户连接...");
            //一直监听
            while (loop) {
                //没有用户连接，程序阻塞在此
                Socket socket = serverSocket.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User user = (User)ois.readObject();
                Message message = new Message();
                if(checkUser(user.getUserName(), user.getPassword())){//验证通过
                    System.out.println("用户 " + user.getUserName() + " 上线...");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //创建线程和客户端保持通讯
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(user.getUserName(), socket);
                    serverConnectClientThread.start();
                    //将线程加入到集合
                    ManageClientThreads.addServerConnectClientThread(user.getUserName(), serverConnectClientThread);
                    //回复消息
                    oos.writeObject(message);
                    //离线缓存功能，不要写在前面，客户端要先读取一个登录状态
                    OfflineServer.check(user.getUserName());
                }else{
                    System.out.println("用户 " + user.getUserName() + " 登录失败...");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                    //回复消息
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            //服务器不再监听，关闭serverSocket
            try {
                if(serverSocket != null){
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void terminateQQServer() {
        loop = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
