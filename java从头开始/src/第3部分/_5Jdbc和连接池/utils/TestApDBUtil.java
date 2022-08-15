package 第3部分._5Jdbc和连接池.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 11:22
 * @Description 第3部分._5Jdbc和连接池.utils
 * @Version 1.0
 */
public class TestApDBUtil {
    public static void main(String[] args) throws Exception{
        //1.获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from actor";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date born_date = resultSet.getDate("born_date");
            String phone = resultSet.getString("phone");
            Actor actor = new Actor(id, name, sex, born_date, phone);
            MyApDBUtil.addActor(actor);
        }
        //2.关闭连接
        JDBCUtilsByDruid.closeConnection(connection, preparedStatement, resultSet);
        //3.查看表信息
        System.out.println("信息如下：");
        ArrayList<Actor> actors = MyApDBUtil.actors;
        for (Actor actor:actors
             ) {
            System.out.println(actor);
        }
    }
}
