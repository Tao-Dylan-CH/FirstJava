package 第3部分._5Jdbc和连接池._3数据库连接方式;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-02 - 01 - 02 - 21:32
 * @Description 第3部分._5Jdbc和连接池._3数据库连接方式
 * @Version 1.0
 */
public class Test {
    /*
        1.创建news表
        2.使用jdbc添加5条数据
        3.修改id=1的记录, 修改content为“jdbc连接”
        4. 删除id=3的记录
     */
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String sql = "create table news(id int primary key auto_increment, content varchar(32))";
        int rows = statement.executeUpdate(sql);
        System.out.println(rows>0?"创表成功！":"创表失败！");
        sql = "insert into news values(null, '北京新闻')," +
                "(null, '南京新闻'),(null, '安徽新闻')," +
                "(null, '上海新闻'), (null, '新疆新闻')";
        rows = statement.executeUpdate(sql);
        if(rows>0){
            System.out.println("添加数据成功！");
        }
        sql = "update news set content='jdbc连接' where id =1";
        statement.executeUpdate(sql);
        sql = "delete from news where id = 3";
        statement.executeUpdate(sql);

        connection.close();
        statement.close();
    }
}
