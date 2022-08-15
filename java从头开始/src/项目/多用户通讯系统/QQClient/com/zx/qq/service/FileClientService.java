package 项目.多用户通讯系统.QQClient.com.zx.qq.service;

import 项目.多用户通讯系统.QQClient.com.zx.qq.common.MessageType;
import 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 挚爱之夕
 * @date 2021/12/15 - 12 - 15 - 10:49
 * @Description com.zx.qq.service
 * @Version 1.0
 * 该类提供文件传输功能
 */
public class FileClientService {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
    public static String saveFileDirectory = "E:/myTemp/";
    /**
     * 私发文件
     * @param sender 发送者
     * @param receiver  接收者
     * @param src   文件路径+文件名
     */
    public void sendFile(String sender, String receiver, String src){
        项目.多用户通讯系统.QQClient.com.zx.qq.common.Message message = new 项目.多用户通讯系统.QQClient.com.zx.qq.common.Message();
        //消息类型
        message.setMessageType(MessageType.MESSAGE_FILE);
        //文件名
        String fileName = new File(src).getName();
        message.setFileName(fileName);
        //发送者
        message.setSender(sender);
        //接收者
        message.setReceiver(receiver);
        //发送时间
        message.setSendTime(formatter.format(LocalDateTime.now()));
        FileInputStream fileInputStream = null;
        File file = new File(src);
        byte[] data = new byte[(int) file.length()];
        int dataLength = 0;
        //文件
        try {
            fileInputStream = new FileInputStream(file);
            dataLength = fileInputStream.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        message.setData(data);
        message.setDataLength(dataLength);
        //发送消息
        ClientConnectServerThread clientConnectServerThread =
                ManageClientConnectServerThread.getClientConnectServerThread(sender);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(clientConnectServerThread.getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存收到的文件
     * @param message       收到的消息
     */
    public static void saveFile(Message message){
        String destination = saveFileDirectory + message.getFileName();
        //创建文件
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(destination);
            byte[] data = message.getData();
            int dataLength = message.getDataLength();
            fileOutputStream.write(data, 0, dataLength);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
