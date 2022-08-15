package 第2部分._15IO流._8Properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 10:07
 * @Description 第2部分._15IO流._8Properties
 * @Version 1.0
 */
public class _1传统方法读取配置文件 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\Jdbc.properties"));
        String line;
        while((line = bufferedReader.readLine())!=null){
            String[] split = line.split("=");
            if(split[0].equals("ip")){
                System.out.println(split[0] + " 为 " + split[1]);
            }
        }
        bufferedReader.close();
    }
}
