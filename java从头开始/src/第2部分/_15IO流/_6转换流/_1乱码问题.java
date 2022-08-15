package 第2部分._15IO流._6转换流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/4 - 12 - 04 - 23:17
 * @Description 第2部分._15IO流._6转换流
 * @Version 1.0
 */
public class _1乱码问题 {
    public static void main(String[] args) throws IOException {
        /*
        读取纯文本文件，默认编码为UTF-8
        如果文件不是UTF-8 编码，中文会出现乱码问题
         */
        BufferedReader reader = new BufferedReader(new FileReader("D:/1.txt"));
        String s = reader.readLine();
        System.out.println(s);
    }
}
