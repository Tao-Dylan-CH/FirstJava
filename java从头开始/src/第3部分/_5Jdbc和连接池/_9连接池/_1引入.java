package 第3部分._5Jdbc和连接池._9连接池;

import 第3部分._5Jdbc和连接池.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @author 挚爱之夕
 * @date 2022-01-03 - 01 - 03 - 18:23
 * @Description 第3部分._5Jdbc和连接池._9连接池._1引入
 * @Version 1.0
 */
public class _1引入 {
    /*
    传统连接数据库5000次
    耗时 15669 ms
     */
    public static void main(String[] args) {
        System.out.println("开始连接");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();
            JDBCUtils.closeConnection(connection, null, null);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + " ms");//耗时： 15669 ms
    }
}
