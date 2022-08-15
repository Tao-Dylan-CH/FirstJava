package 项目.多用户通讯系统.QQClient.com.zx.qq.service;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.User;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 12:01
 * @Description 项目.多用户通讯系统.Client.service
 * @Version 1.0
 * 该类提供用户登录、退出、请求在线用户列表等功能
 */
public class UserClientService {
    //可能在其他地方使用，所有做出成员属性
    private final User user = new User();
    //日期格式化器
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
    /*登录验证*/
    public boolean checkUser(String id, String password){
        boolean isConnected = false;
        user.setUserName(id);
        user.setPassword(password);
        try {
            //连接服务器192.168.137.1
            Socket socket = new Socket(InetAddress.getByName("LAPTOP-GIK86SC8"), 9999);//172.27.144.1
            //发送用户信息
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user);

            //接收服务器返回的消息

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            项目.多用户通讯系统.QQClient.com.zx.qq.common.Message message = (项目.多用户通讯系统.QQClient.com.zx.qq.common.Message) ois.readObject();

            if(message.getMessageType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){//登录成功
                //为了和服务端保持通信，需要启动一个线程，持有当前socket,需要创建一个线程类
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                //启动线程
                clientConnectServerThread.start();
                //为了后面客户端扩展，将线程添加到集合
                ManageClientConnectServerThread.addClientConnectServerThread(id, clientConnectServerThread);
                isConnected = true;
            }else{  //登录失败
                //这里与服务器连接失败，需要关闭socket
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isConnected;
    }
    /*请求在线用户列表*/
    public void onlineFriends(){
        项目.多用户通讯系统.QQClient.com.zx.qq.common.Message message = new 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message();
        message.setSender(user.getUserName());
        message.setSendTime(formatter.format(LocalDateTime.now()));
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIENDS);
        //得到当前线程
        ClientConnectServerThread clientConnectServerThread =
                ManageClientConnectServerThread.getClientConnectServerThread(user.getUserName());
        //得到socket
        Socket socket = clientConnectServerThread.getSocket();
        try {
            //得到输入流,向服务器发送请求
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*无异常退出*/
    public void sendExitMessage(){
        项目.多用户通讯系统.QQClient.com.zx.qq.common.Message message = new Message();
        message.setSendTime(formatter.format(LocalDateTime.now()));
        message.setMessageType(MessageType.MESSAGE_Client_EXIT);
        //得到当前线程
        ClientConnectServerThread clientConnectServerThread =
                ManageClientConnectServerThread.getClientConnectServerThread(user.getUserName());
        //得到socket
        Socket socket = clientConnectServerThread.getSocket();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
