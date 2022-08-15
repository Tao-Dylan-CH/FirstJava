package 第3部分._5Jdbc和连接池._9连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-04 - 01 - 04 - 19:42
 * @Description 第3部分._5Jdbc和连接池._9连接池
 * @Version 1.0
 * 演示c3p0连接池
 */
public class _2c3p0方式1 {
    public static void main(String[] args) throws Exception{
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件得到相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/Jdbc.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        //3.为数据源对象设置相关参数
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //4.初始化，设置最大连接数
        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(50);


        //5.测试5000次连接耗时
        System.out.println("开始连接...");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        //c3p0连接5000次，耗时：275 ms
        System.out.println("c3p0连接5000次，耗时：" + (end - start) + " ms");
    }
}
