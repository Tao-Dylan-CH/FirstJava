package 第3部分._5Jdbc和连接池._1模拟实现Jdbc;

/**
 * @author 挚爱之夕
 * @date 2022-01-01 - 01 - 01 - 23:16
 * @Description 第3部分._5Jdbc和连接池._1模拟实现Jdbc
 * @Version 1.0
 * 模拟Jdbc 接口
 */
public interface JdbcInterface {
    void getConnect();
    void crud();
    void close();
}
