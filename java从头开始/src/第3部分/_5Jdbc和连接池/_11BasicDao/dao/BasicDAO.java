package 第3部分._5Jdbc和连接池._11BasicDao.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import 第3部分._5Jdbc和连接池._11BasicDao.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2022-01-05 - 01 - 05 - 20:00
 * @Description 第3部分._5Jdbc和连接池._11BasicDao.dao
 * @Version 1.0
 * BasicDAO 是其他DAO的父类
 */
public class BasicDAO<T> {
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * DML操作
     * @param sql sql语句
     * @param parameters sql的填充
     * @return  受影响的行数
     */
    public int update(String sql, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.update(connection, sql, parameters);
        } catch (SQLException e) {
           throw new RuntimeException();
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
    }

    /**
     * 查询多行多列数据
     * @param sql   sql语句
     * @param clazz 行数据对应包装类
     * @param parameters sql语句填充
     * @return  返回行数
     */
    public List<T> queryMultiply(String sql, Class<T> clazz, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
    }

    /**
     * 查询单行数据
     * @param sql sql语句
     * @param clazz 行数据对应包装类
     * @param parameters sql语句填充
     * @return 返回行数
     */
    public T querySignal(String sql, Class<T> clazz, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
    }

    /**
     * 返回单行单列（一个数据）
     * @param sql sql语句
     * @param parameters sql语句填充
     * @return null if not exist or Object if exist
     */
    public Object queryScalar(String sql, Object... parameters){
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JDBCUtilsByDruid.closeConnection(connection, null, null);
        }
    }
}
