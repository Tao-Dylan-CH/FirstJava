package 第3部分._5Jdbc和连接池.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 挚爱之夕
 * @date 2022-01-04 - 01 - 04 - 21:45
 * @Description 第3部分._5Jdbc和连接池.utils
 * @Version 1.0
 */
public class TestDruid {
    public static void main(String[] args) throws Exception {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            System.out.println(name + "\t" + password);
        }
        JDBCUtilsByDruid.closeConnection(connection, preparedStatement, resultSet);
    }
}
