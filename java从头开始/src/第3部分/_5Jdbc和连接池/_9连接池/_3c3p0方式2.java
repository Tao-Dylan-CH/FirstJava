package 第3部分._5Jdbc和连接池._9连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 挚爱之夕
 * @date 2022-01-04 - 01 - 04 - 20:58
 * @Description 第3部分._5Jdbc和连接池._9连接池
 * @Version 1.0
 */
public class _3c3p0方式2 {
    public static void main(String[] args) throws SQLException {
        //参数为配置文件中，数据源名
        ComboPooledDataSource datePool = new ComboPooledDataSource("dataPool");
        Connection connection = datePool.getConnection();
        System.out.println("连接成功...");
        connection.close();
    }
}
