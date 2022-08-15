package 第2部分._15IO流._8Properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 10:41
 * @Description 第2部分._15IO流._8Properties
 * @Version 1.0
 */
public class _3Properties创建配置文件 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //创建键值对
        properties.setProperty("user", "李白");
        properties.setProperty("psw", "12345");
        //comments是描述信息，null表示没有描述信息
        properties.store(new FileWriter("src/mysql2.properties"), "李白的账号");
        //若果目标文件与写入key对重复，则替换value。
        //不重复创建键值对
        System.out.println("配置文件创建成功！");
    }
}
