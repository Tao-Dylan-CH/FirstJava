package 第3部分._5Jdbc和连接池._10ApDBUtil;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;
import 第3部分._5Jdbc和连接池.utils.Actor;
import 第3部分._5Jdbc和连接池.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 16:38
 * @Description 第3部分._5Jdbc和连接池._10ApDBUtil
 * @Version 1.0
 * Druid + ApacheUtil 演示查询数据库db01 下 actor表
 */
public class _1查询表 {
    /*
    传统的查询，得到的结果集
    在连接关闭后无法使用
    ApacheUtil 将结果集数据封装到List<Bean>中
    每个行数据对应一个Bean对象
    执行查询：queryRunner.query()
     */
    public static void main(String[] args) throws Exception{

    }
    /*
    多行查询
     */
    @Test
    public void testQueryMultiple() throws Exception{
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from actor where id > ?";
        //2.创建QueryRunner对象 使用需要导入第三方库：commons-dbutils.jar
        QueryRunner queryRunner = new QueryRunner();
        //3.执行查询
        /*
        new BeanListHandler<>(Actor.class)
        传入的是行数据对应的类的类型
        后面是可变参数，依次对应sql语句中的?
         */
        List<Actor> actorList =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 0);
        for (Actor actor:actorList
        ) {
            System.out.println(actor);
        }

        //4.关闭连接    只需要关闭connection
        JDBCUtilsByDruid.closeConnection(connection, null, null);
    }
    /*
    单行查询
     */
    @Test
    public void testQuerySingle() throws Exception{
        //1.得到连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from actor where id = ?";
        //2.创建QueryRunner对象 使用需要导入第三方库：commons-dbutils.jar
        QueryRunner queryRunner = new QueryRunner();
        //3.执行查询 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
        System.out.println(actor);
        //4.关闭连接    只需要关闭connection
        JDBCUtilsByDruid.closeConnection(connection, null, null);
    }
    /*
    单行单列
     */
    @Test
    public void testQueryScalar() throws Exception{
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select name from actor where id = ?";
        Object o = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println(o);
        JDBCUtilsByDruid.closeConnection(connection, null, null);
    }
}
