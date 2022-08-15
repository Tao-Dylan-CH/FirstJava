package 第3部分._5Jdbc和连接池._4ResultSet;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 22:18
 * @Description 第3部分._5Jdbc和连接池.ResultSet
 * @Version 1.0
 */
public class _1查找表 {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        //1.加载驱动
        Class.forName(driver);
        //2.获得连接
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String sql = "select id, name, sex, born_date, phone from actor";
        //3.得到结果集
        ResultSet resultSet = statement.executeQuery(sql);
        //4.遍历结果集
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            String phone = resultSet.getString(5);
            System.out.println(id+"\t"+name+"\t"+sex+"\t"+date+"\t"+phone);
        }
        /*
            1	李白	男	1999-03-01	111
            2	王昭君	女	2000-01-01	222

         */
        //5.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
