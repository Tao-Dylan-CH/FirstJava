package 项目.多用户通讯系统.QQClient.com.zx.qq.common;

import java.io.Serializable;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 10:04
 * @Description 项目.多用户通讯系统.Client.common
 * @Version 1.0
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String content; //内容
    private String sender;  //发送者
    private String receiver;//接收者
    private String messageType;    //消息类型
    private String sendTime;//发送时间

    //文件相关
    private byte[] data;        //数据
    private int dataLength = 0; //大小
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public Message(){

    }
    public Message(String content, String sender, String receiver, String type, String sendTime) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.messageType = type;
        this.sendTime = sendTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
