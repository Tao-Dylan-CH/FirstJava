package 第3部分._5Jdbc和连接池._8批处理;


import org.junit.jupiter.api.Test;
import 第3部分._5Jdbc和连接池.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 挚爱之夕
 * @date 2022-01-03 - 01 - 03 - 16:14
 * @Description 第3部分._5Jdbc和连接池._8批处理
 * @Version 1.0
 * 演示批处理和一条条执行sql语句的耗时对比
 */
public class Demo {
    /*
    向数据库db01下
    batchTest表加入5000条数据
    使用批处理需要在url后追加 ：?rewriteBatchedStatements=true
     */
    @Test
    public void noBatch(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into batchTest values (?, ?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("开始执行...");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, null);
                preparedStatement.setString(2, "tom" + (i+1));
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时： " + (end - start) + " ms");//3344 ms
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
    }
    @Test
    public void batch(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // values和()之间有个空格，不然一样慢，不知道为什么
        String sql = "insert into batchTest values (?, ?)";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("开始执行...");
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1, null);
                preparedStatement.setString(2, "tom" + (i+1));
                preparedStatement.addBatch();//添加到批处理包
                if((i + 1) % 1000 == 0){//到一千个数据，批处理
                    preparedStatement.executeBatch();//批处理
                    preparedStatement.clearBatch(); //清空数据包
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时： " + (end - start) + " ms");//耗时： 277 ms
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
    }
}
