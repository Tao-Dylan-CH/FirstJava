package 项目.多用户通讯系统.QQServer.com.zx.qq.common;

import java.io.Serializable;

/**
 * @author 挚爱之夕
 * @date 2021/12/12 - 12 - 12 - 10:00
 * @Description 项目.多用户通讯系统.Server.common
 * @Version 1.0
 * 一个用户信息
 */
public class User implements Serializable {
    private String userName;
    private String password;
    private static final long serialVersionUID = 1L;
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
