package 第2部分._15IO流._3处理流;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/2 - 12 - 02 - 16:08
 * @Description 第2部分._15IO流._3处理流
 * @Version 1.0
 */
public class _2BufferedWriter {
    /*
    使用BufferedWriter 写字符串到文件
     */
    @Test
    void writeFile(){
        BufferedWriter bufferedWriter = null;
        String str = "使用BufferedWriter 写字符串到文件";
        try {
            //带true 表示追加，不带 覆盖
            bufferedWriter = new BufferedWriter(new FileWriter("D:/2.txt" , true));
            bufferedWriter.write(str);
            bufferedWriter.newLine();   //插入一个与当前系统相关的换行符
            bufferedWriter.write("我换行了...");
            System.out.println("写入成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
