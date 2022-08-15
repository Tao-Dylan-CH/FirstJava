package 第3部分._5Jdbc和连接池._3数据库连接方式;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 9:22
 * @Description 第3部分._5Jdbc和连接池._3数据库连接方式
 * @Version 1.0
 * 动态加载
 */
public class _2Demo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zt200039");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }
}
