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
 * 静态加载
 */
public class _1Demo {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/db01";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zt200039");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }
}
