package 第2部分._4接口;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 17:06
 * @Description 第2部分._4接口
 * @Version 1.0
 */
public class _2接口 {
    //规范方法名
    public static void operator(MyInterface myInterface){
        myInterface.connect();
        myInterface.close();
    }
    public static void main(String[] args) {
        operator(new MysqlDB());
        operator(new OracleDB());
    }
}
interface MyInterface{
    void connect();
    void close();
}
class MysqlDB implements MyInterface{
    @Override
    public void connect() {
        System.out.println("连接Mysql数据库。");
    }

    @Override
    public void close() {
        System.out.println("断开Mysql数据连接。");
    }
}
class OracleDB implements MyInterface{
    @Override
    public void connect() {
        System.out.println("连接Oracle数据库。");
    }

    @Override
    public void close() {
        System.out.println("断开Oracle数据连接。");
    }
}
