package 项目.多用户通讯系统.QQClient.com.zx.qq.view;


import 项目.多用户通讯系统.QQClient.com.zx.qq.service.FileClientService;
import 项目.多用户通讯系统.QQClient.com.zx.qq.service.MessageClientService;
import 项目.多用户通讯系统.QQClient.com.zx.qq.service.UserClientService;
import 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility;

import java.io.File;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 10:27
 * @Description 项目.多用户通讯系统.Client.view
 * @Version 1.0
 */
public class ClientView {
    private boolean loop = true;
    //用于登录、退出
    private final UserClientService service = new UserClientService();
    //用于消息
    private final MessageClientService messageClientService = new MessageClientService();
    //用于发送文件
    private final FileClientService fileClientService = new FileClientService();
    public void mainMenu(){
        while(loop){
            System.out.println("----------多用户通讯系统----------");
            System.out.println("1 登录");
            System.out.println("9 退出");
            System.out.print("请选择：");
            String choice = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(1);
            switch (choice){
                case "1":
                    System.out.print("输入用户名:");
                    String id = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(20);
                    System.out.print("输入密码:");
                    String password = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(20);
                    //登录成功
                    if(service.checkUser(id, password)){
                        String content;
                        while(loop){
                            System.out.println("----------二级菜单("+id+")----------");
                            System.out.println("1 显示在线用户列表");
                            System.out.println("2 群发消息");
                            System.out.println("3 私发消息");
                            System.out.println("4 发送文件");
                            System.out.println("9 退出系统");
                            System.out.print("请选择：");
                            choice = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(1);
                            switch (choice){
                                case "1":
                                    //请求在线用户信息
                                    service.onlineFriends();
                                    break;
                                case "2":
                                    System.out.println("输入消息内容：");
                                    content = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(200);
                                    //群发消息
                                    messageClientService.sendPublicMessage(id, content);
                                    break;
                                case "3":
                                    System.out.print("输入对方id:");
                                    String friend = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(20);
                                    System.out.print("输入消息内容：");
                                    content = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(200);
                                    //私发消息
                                    messageClientService.sendPrivateMessage(id, friend, content);
                                    break;
                                case "4":
                                    System.out.print("输入对方ID:");
                                    friend = 项目.多用户通讯系统.QQClient.com.zx.qq.utils.Utility.readString(20);
                                    System.out.print("输入文件路径:");
                                    String src = Utility.readString(100);
                                    fileClientService.sendFile(id, friend, src);
                                    System.out.println("你向 " + friend + " 发送了文件：" + new File(src).getName());
                                    break;
                                case "9":
                                    loop = false;
                                    //向服务器发送退出消息
                                    service.sendExitMessage();
                                    //退出程序
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("输入有误");
                            }
                        }
                    }else{
                        System.out.println("登录失败");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
                default:
                    System.out.println("输入有误");
            }
        }
    }
}
