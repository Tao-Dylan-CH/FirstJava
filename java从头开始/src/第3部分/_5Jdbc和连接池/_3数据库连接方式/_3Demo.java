package 第3部分._5Jdbc和连接池._3数据库连接方式;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 9:44
 * @Description 第3部分._5Jdbc和连接池._3数据库连接方式
 * @Version 1.0
 * 使用DriverManager替代Driver进行管理
 */
public class _3Demo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "zt200039";
        DriverManager.deregisterDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
