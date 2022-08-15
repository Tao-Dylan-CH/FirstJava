package 第3部分._5Jdbc和连接池._2Jdbc入门;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-01 - 01 - 01 - 23:40
 * @Description 第3部分._5Jdbc和连接池._2Jdbc入门
 * @Version 1.0
 * 这时第一个Jdbc 程序
 */
public class Jdbc {
    /*
    前置工作：
    1.新建一个目录lib
    2.将mysql.jar 复制到lib下
    3.添加到项目：add as library
     */
    public static void main(String[] args) throws SQLException {
        //1. 注册驱动
        Driver driver = new Driver();

        //2. 得到连接
        /*
        说明：
        jdbc:mysql://  : 固定好的，表示协议，通过jdbc的方式连接mysql
        localhost      : ip地址
        3306           : 表示mysql监听的端口
        db01           : 数据库名
        mysql的连接本质是socket连接
         */
        String url = "jdbc:mysql://localhost:3306/db01";
        //将 用户名和密码 放入Properties 对象
        Properties properties = new Properties();
        // user 和 password 是规定好的， 值根据实际情况写
        properties.setProperty("user", "root");
        properties.setProperty("password", "zt200039");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
        //3.执行sql
        String sql = "insert into actor values(null, '李白', '男', '1970-11-11', '111')";
        String sql2 = "update actor set borndate = '2000-1-1' where name = '李白'";
        //statement 用于执行sql语句，并返回结果对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql2);//如果是dml语句，返回的是影响的行数
        System.out.println(rows > 0 ? "成功":"失败");

        //4.关闭连接
        connect.close();
        statement.close();
    }
}
