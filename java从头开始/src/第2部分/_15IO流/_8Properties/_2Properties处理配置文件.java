package 第2部分._15IO流._8Properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 10:30
 * @Description 第2部分._15IO流._8Properties
 * @Version 1.0
 */
public class _2Properties处理配置文件 {
    public static void main(String[] args) throws IOException {
        //1、创建对象
        Properties properties = new Properties();
        //2、加载配置文件
        properties.load(new FileReader("src/Jdbc.properties"));
        //3、得到配置信息,输出到指定设备
        properties.list(System.out);
        //3、根据键得到值
        String ip = properties.getProperty("ip");
        System.out.println("ip是" + ip);
    }
}
