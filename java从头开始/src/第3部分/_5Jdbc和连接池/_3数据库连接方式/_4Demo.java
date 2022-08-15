package 第3部分._5Jdbc和连接池._3数据库连接方式;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 9:52
 * @Description 第3部分._5Jdbc和连接池._3数据库连接方式
 * @Version 1.0
 * 使用反射加载Driver类，不需要再注册驱动
 */
public class _4Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "Jdbc:mysql://localhost:3306/db01";
        String user = "root";
        String password = "zt200039";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        /*
        com.mysql.jdbc.Driver
        底层源码：
        static {
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException var1) {
                throw new RuntimeException("Can't register driver!");
            }
        }
        加载该类时，会加载静态代码块
        向DriverManager注册驱动
         */
    }
}
