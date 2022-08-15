package 第3部分._5Jdbc和连接池._10ApDBUtil;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.jupiter.api.Test;
import 第3部分._5Jdbc和连接池.utils.JDBCUtilsByDruid;

import java.sql.Connection;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 17:29
 * @Description 第3部分._5Jdbc和连接池._10ApDBUtil
 * @Version 1.0
 * Druid + ApDBUtil 演示DML
 */
public class _2DML表 {
    /*
    执行DML语句：queryRunner.update(）
     */

    //演示Update
    @Test
    public void testUpdate() throws Exception{
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update actor set name = ? where id = ?";
        int affectedRows = queryRunner.update(connection, sql, "jack", 3);
        System.out.println(affectedRows > 0 ? "修改成功..." : "修改失败");
        JDBCUtilsByDruid.closeConnection(connection, null, null);
    }

    //演示insert
    @Test
    public void testInsert() throws Exception{
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into actor values(?,?,?,?,?)";
        int affectedRows =
                queryRunner.update(connection, sql, null, "tom", "男", "1999-1-1", "444");
        System.out.println(affectedRows > 0 ? "添加成功..." : "添加失败");
        JDBCUtilsByDruid.closeConnection(connection, null, null);
    }

    //演示delete
    @Test
    public void testDelete() throws Exception{
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "delete from actor where id = ?";
        int affectedRows = queryRunner.update(connection, sql, 4);
        System.out.println(affectedRows > 0 ? "删除成功..." : "删除失败...");
        JDBCUtilsByDruid.closeConnection(connection, null, null);
    }
}
