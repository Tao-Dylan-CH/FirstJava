package 第3部分._5Jdbc和连接池._7事务;

import org.junit.Test;
import 第3部分._5Jdbc和连接池.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 挚爱之夕
 * @date 2022-01-03 - 01 - 03 - 15:25
 * @Description 第3部分._5Jdbc和连接池.事务
 * @Version 1.0
 */
public class _1模拟转账 {
    /*
    在db01数据库下
    创建一张account表
    插入两个数据，模拟转账
     */

    @Test
    public void createTable(){  // 建表
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "create table account(id int primary key auto_increment, name varchar(32) , balance double)";
        String sql2 = "insert into account values(null, '马化腾', 10000),(null, '赵云', 5000)";
        try {
            connection = JDBCUtils.getConnection();
            //建表
            preparedStatement = connection.prepareStatement(sql);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows== 0?"创建表成功":"创建表失败");
            //添加数据
            preparedStatement = connection.prepareStatement(sql2);
            rows = preparedStatement.executeUpdate();
            System.out.println(rows>0?"添加数据成功":"添加数据失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
    }
    @Test
    public void transferAccountsWithOutTransaction(){//没有事务的转账
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update account set balance = balance - 100 where name = '赵云'";
        String sql2 = "update account set balance = balance + 100 where name = '马化腾'";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            //模拟中途出现异常
            int i = 10/0;   //赵云余额减100，马化腾没有收到转账
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
    }
    @Test
    public void transferAccountWithTransaction(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update account set balance = balance - 100 where name = '赵云'";
        String sql2 = "update account set balance = balance + 100 where name = '马化腾'";
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            //模拟中途出现异常
            int i = 10/0;   //因为设置了不自动提交事务，发生异常，转账失败
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            connection.commit();    //提交事务
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);
        }
    }
}
