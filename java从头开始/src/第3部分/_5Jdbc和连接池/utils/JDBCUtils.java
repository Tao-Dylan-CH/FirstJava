package 第3部分._5Jdbc和连接池.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-03 - 01 - 03 - 10:38
 * @Description 第3部分._5Jdbc和连接池.utils
 * @Version 1.0
 * 数据库连接工具类
 */
public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/Jdbc.properties"));
            //读取相关数据值
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

        } catch (IOException e) {
            //实际开发中，这样处理：
            //1.将编译异常转为运行异常，抛出
            //2.这样使用者可以选择处理，或默认处理，很方便
            throw new RuntimeException();
        }
    }

    /**
     * 得到连接
     * @return  连接
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 关闭连接
     * 不需要关闭传入null
     * @param connection 连接
     * @param statement  Statement or PreparedStatement
     * @param resultSet  结果集
     */
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {

        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
