package 项目.多用户通讯系统.QQClient.com.zx.qq;

import 项目.多用户通讯系统.QQClient.com.zx.qq.view.ClientView;

import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date  2021/12/12 - 12 - 12 - 10:39
 * @Description 项目.多用户通讯系统.Client
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
        new ClientView().mainMenu();
    }
}
