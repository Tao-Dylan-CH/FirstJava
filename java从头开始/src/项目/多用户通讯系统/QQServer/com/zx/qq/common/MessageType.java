package 项目.多用户通讯系统.QQServer.com.zx.qq.common;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 10:10
 * @Description 项目.多用户通讯系统.Server.common
 * @Version 1.0
 * 消息类型
 */
public interface MessageType {
    /*
    不同的常量对应不同的消息类型
     */
    String MESSAGE_LOGIN_SUCCEED = "1"; //登录成功
    String MESSAGE_LOGIN_FAIL = "2";    //登录失败
    String MESSAGE_COMMON = "3";    //普通消息
    String MESSAGE_GET_ONLINE_FRIENDS = "4"; //请求在线用户列表
    String MESSAGE_RET_ONLINE_FRIENDS = "5";  //返回在线用户列表
    String MESSAGE_Client_EXIT = "6";       //用户端退出
    String MESSAGE_TO_ALL = "7";            //群发消息
    String MESSAGE_FILE = "8";              //发送文件
    String MESSAGE_NOTICE = "9";            //服务器推送的消息
}
