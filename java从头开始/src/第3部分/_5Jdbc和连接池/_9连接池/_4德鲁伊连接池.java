package 第3部分._5Jdbc和连接池._9连接池;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2022-01-04 - 01 - 04 - 21:09
 * @Description 第3部分._5Jdbc和连接池._9连接池
 * @Version 1.0
 */
public class _4德鲁伊连接池 {
    public static void main(String[] args) throws Exception {
        //1.导包 lib下
        //2.创建配置文件 src下
        //3.读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));

        //4.创建指定参数的数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        // 德鲁伊连接池5000次连接，耗时：320 ms
        System.out.println("德鲁伊连接池5000次连接，耗时：" + (end - start) + " ms");
    }
}
