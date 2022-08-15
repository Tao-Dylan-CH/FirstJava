package 第3部分._5Jdbc和连接池._6PreparedStatement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-03 - 01 - 03 - 9:31
 * @Description 第3部分._5Jdbc和连接池._6PreparedStatement
 * @Version 1.0
 */
public class _3HomeWork {
    /*
    1. 创建 user 表
    2. 使用PreparedStatement 添加 5条数据
    3. 修改 tom 的记录，将name 改成 king
    4. 删除king的记录
    5. 查询全部记录显示在控制台
     */
    public static void main(String[] args) throws Exception{
        //从配置文件获取信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Jdbc.properties"));

        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        //加载驱动
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        //创建表
        String sql = "create table user(name varchar(32), password varchar(32))";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();

        //添加数据
        String sql1 = "insert into user values(?,?),(?,?),(?,?),(?,?),(?,?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
        preparedStatement1.setString(1, "tom");
        preparedStatement1.setString(2, "111");
        preparedStatement1.setString(3, "harry");
        preparedStatement1.setString(4, "222");
        preparedStatement1.setString(5, "ron");
        preparedStatement1.setString(6, "333");
        preparedStatement1.setString(7, "hermione");
        preparedStatement1.setString(8, "444");
        preparedStatement1.setString(9, "draco");
        preparedStatement1.setString(10, "555");
        int rows = preparedStatement1.executeUpdate();
        System.out.println(rows > 0 ? "添加成功":"添加失败");

        //修改 tom 的记录，将name 改成 king
        String sql2 = "update user set name='king' where name='tom'";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        int rows1 = preparedStatement2.executeUpdate();
        System.out.println(rows1 > 0 ? "修改成功":"修改失败");

        //删除king的记录
        String sql3 = "delete from user where name = 'king'";
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
        preparedStatement3.executeUpdate();

        //显示表所有数据
        String sql4 = "select * from user";
        PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
        ResultSet resultSet = preparedStatement4.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString(1);
            String pwd = resultSet.getString(2);
            System.out.println(name + "\t" + pwd);
        }

        preparedStatement.close();
        preparedStatement1.close();
        preparedStatement2.close();
        preparedStatement3.close();
        preparedStatement4.close();
        resultSet.close();
        connection.close();
    }
}
