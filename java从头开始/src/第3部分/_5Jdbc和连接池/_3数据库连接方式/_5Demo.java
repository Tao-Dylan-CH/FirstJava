package 第3部分._5Jdbc和连接池._3数据库连接方式;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 10:12
 * @Description 第3部分._5Jdbc和连接池._3数据库连接方式
 * @Version 1.0
 * 在方式4的基础上，使用配置文件
 */
public class _5Demo {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Jdbc.properties"));
        Class.forName(properties.getProperty("driver"));//最好写上
        Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password"));
        System.out.println(connection);
    }
}
