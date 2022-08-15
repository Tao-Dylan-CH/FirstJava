package 第2部分._15IO流._6转换流;

import java.io.*;

/**
 * @author 挚爱之夕
 * @date 2021/12/4 - 12 - 04 - 23:29
 * @Description 第2部分._15IO流._6转换流
 * @Version 1.0
 */
public class _2InputStreamReader {
    public static void main(String[] args) throws IOException {
        //1.字节流->转换流(可以指定编码格式)
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:/1.txt"), "gbk");
        //2.转换流->字符流
        BufferedReader br = new BufferedReader(isr);
        //3.读取
        String s = br.readLine();
        System.out.println(s);
        //4.关闭外层流
        br.close();

    }
}
