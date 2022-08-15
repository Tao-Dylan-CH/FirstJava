package 第3部分._5Jdbc和连接池._1模拟实现Jdbc;

/**
 * @author 挚爱之夕
 * @date 2022-01-01 - 01 - 01 - 23:19
 * @Description 第3部分._5Jdbc和连接池._1模拟实现Jdbc
 * @Version 1.0
 * 模拟连接
 */
public class Test {
    public static void main(String[] args) {
        JdbcInterface mysqlJdbcImplement = new MysqlJdbcImplement();
        mysqlJdbcImplement.getConnect();
        mysqlJdbcImplement.crud();
        mysqlJdbcImplement.close();
    }
}
