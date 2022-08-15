package 第3部分._5Jdbc和连接池.utils;

import java.util.Date;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 11:16
 * @Description 第3部分._5Jdbc和连接池.utils
 * @Version 1.0
 * 一个Actor 对象 对应db01数据库下actor表的一行行数据
 */
public class Actor {
    private int id;
    private String name;
    private String sex;
    private Date bornDate;
    private String phone;

    public Actor() {
    }

    public Actor(int id, String name, String sex, Date bornDate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.bornDate = bornDate;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", bornDate=" + bornDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
