package 第3部分._5Jdbc和连接池._5SQL注入问题;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 23:02
 * @Description 第3部分._5Jdbc和连接池.SQL注入问题
 * @Version 1.0
 * 演示Statement 存在的SQL注入问题
 */
public class Demo {
    /*
    用户输入用户名和密码

    SQL注入
    输入用户名 为 1' or
    输入密码   为 or '1' = '1
    SELECT * FROM admin
    WHERE `name` = '1' OR' AND `password`= 'OR '1' = '1';
     */
    public static void main(String[] args) throws Exception{
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
        Statement statement = connection.createStatement();

//        String sql = "select * from admin where name = 'tom' and password='123'";
        String sql = "select * from admin where name = '" + name
                + "' and password = '" + pwd + "'";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
