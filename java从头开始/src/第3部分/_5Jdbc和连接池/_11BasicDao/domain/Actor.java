package 第3部分._5Jdbc和连接池._11BasicDao.domain;

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
    private Date born_date;
    private String phone;

    public Actor() {
    }

    public Actor(int id, String name, String sex, Date born_date, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.born_date = born_date;
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

    public Date getBorn_date() {
        return born_date;
    }

    public void setBorn_date(Date born_date) {
        this.born_date = born_date;
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
                ", born_date=" + born_date +
                ", phone='" + phone + '\'' +
                '}';
    }
}
