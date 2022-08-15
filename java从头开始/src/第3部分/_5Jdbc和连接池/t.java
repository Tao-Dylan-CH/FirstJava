package 第3部分._5Jdbc和连接池;

import 第3部分._5Jdbc和连接池.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 挚爱之夕
 * @date 2022-01-01 - 01 - 01 - 23:11
 * @Description 第3部分._5Jdbc和连接池
 * @Version 1.0
 */
public class t {
    public static void main(String[] args){
        batch();
    }
    public static void batch(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into batchTest values(?, ?)";
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
            System.out.println("耗时： " + (end - start) + " ms");//3344 ms
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
    }
}
