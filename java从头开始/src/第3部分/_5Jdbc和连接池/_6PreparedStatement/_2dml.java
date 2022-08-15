package 第3部分._5Jdbc和连接池._6PreparedStatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-03 - 01 - 03 - 9:01
 * @Description 第3部分._5Jdbc和连接池._6PreparedStatement
 * @Version 1.0
 */
public class _2dml {
    /*
    对db01数据库下
    admin表
    dml
     */
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        //insert语句 添加用户李白
        String sql = "insert into admin values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "李白");
        preparedStatement.setString(2, "111");
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "添加成功":"添加失败");

//        //update语句  修改李白密码
//        String sql1 = "update admin set password=? where name = '李白'";
//        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
//        preparedStatement1.setString(1, "000");
//        int rows1 = preparedStatement1.executeUpdate();
//        System.out.println(rows1 > 0 ? "修改成功":"修改失败");

//        //delete语句 删除用户李白
//        String sql2 = "delete from admin where name = '李白'";
//        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
//        int rows2 = preparedStatement2.executeUpdate();
//        System.out.println(rows2 > 0 ? "删除成功":"删除失败");

        preparedStatement.close();
//        preparedStatement1.close();
//        preparedStatement2.close();
        connection.close();
    }
}
