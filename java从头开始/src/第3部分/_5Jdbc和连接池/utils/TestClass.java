package 第3部分._5Jdbc和连接池.utils;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * @author 挚爱之夕
 * @date 2022-01-03 - 01 - 03 - 10:55
 * @Description 第3部分._5Jdbc和连接池.utils
 * @Version 1.0
 * 演示工具类的使用
 */
public class TestClass {
    /*
    db01数据库下
    user表
     */
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    @Before
    public void testGetConnection(){
        connection = JDBCUtils.getConnection();
    }
    @Test
    public void testInsert(){
        String sql = "insert into user values(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "dylan");
            preparedStatement.setString(2, "2000");
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "添加成功" : "添加失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDelete(){
        String sql = "delete from user where name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "dylan");
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "删除成功" : "删除失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdate(){
        String sql = "update user set password = ? where name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "harry's pwd");
            preparedStatement.setString(2, "harry");
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "修改成功" : "修改失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect(){
        String sql = "select * from user";
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                System.out.println(name + "\t" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void testClose(){
        JDBCUtils.closeConnection(connection, statement, resultSet);
    }


}
