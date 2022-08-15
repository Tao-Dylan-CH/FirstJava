package 第2部分._15IO流._3处理流;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/2 - 12 - 02 - 16:00
 * @Description 第2部分._15IO流._3处理流
 * @Version 1.0
 */
public class _1BufferedReader {
    /*用BufferedReader读取文本文件*/
    @Test
    void readFile(){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("D:/1.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("读取完毕...");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
