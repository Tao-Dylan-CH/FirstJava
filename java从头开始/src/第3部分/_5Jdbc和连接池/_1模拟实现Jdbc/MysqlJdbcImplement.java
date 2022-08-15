package 第3部分._5Jdbc和连接池._1模拟实现Jdbc;

/**
 * @author 挚爱之夕
 * @date 2022-01-01 - 01 - 01 - 23:18
 * @Description 第3部分._5Jdbc和连接池._1模拟实现Jdbc
 * @Version 1.0
 * 模拟mysql实现jdbc
 */
public class MysqlJdbcImplement implements JdbcInterface{

    @Override
    public void getConnect() {
        System.out.println("连接到mysql数据库...");
    }

    @Override
    public void crud() {
        System.out.println("对mysql数据库进行增删改查...");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql数据库连接...");
    }
}
