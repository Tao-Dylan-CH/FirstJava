package 第3部分._5Jdbc和连接池.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-04 - 01 - 04 - 21:34
 * @Description 第3部分._5Jdbc和连接池.utils
 * @Version 1.0
 * 德鲁伊连接池工具类
 */
public class JDBCUtilsByDruid {
    public static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    /* 这里并不是关闭连接，而是将Connection对象放回连接池 */
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();// 德鲁伊close()方法，不是断开连接
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
