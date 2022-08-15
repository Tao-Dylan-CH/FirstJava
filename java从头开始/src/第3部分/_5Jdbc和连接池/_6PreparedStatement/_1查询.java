package 第3部分._5Jdbc和连接池._6PreparedStatement;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 23:31
 * @Description 第3部分._5Jdbc和连接池._6PreparedStatement
 * @Version 1.0
 * 演示PreparedStatement
 * 没有SQL注入问题
 */
public class _1查询 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) throws Exception{
        /*
        查询db01数据库下
        admin表
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入用户名：");
        String name = scanner.nextLine();   //为了演示效果，读一行
        System.out.print("输入密码：");
        String pwd = scanner.nextLine();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "select * from admin where name = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);
        //preparedStatement与sql语句绑定，不需要给参数
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
