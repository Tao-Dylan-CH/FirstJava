package 第2部分._15IO流._2节点流;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 23:37
 * @Description 第2部分._15IO流._2输入输出流
 * @Version 1.0
 */
public class _4FileWriter {
    public static void main(String[] args) {

    }
    @Test
    void method(){
        FileWriter fileWriter = null;
        try {
            //覆盖:        new FileWriter("D:/2.txt")
            //追加：       new FileWriter("D:/2.txt", true)
            fileWriter = new FileWriter("D:/2.txt");
            String s = "风雨后，见彩虹。";
            //1.write(int)
            fileWriter.write(111);
            fileWriter.write('急');
            //2.write(char[])
            char[] ch = {'Z', 'T'};
            fileWriter.write(ch);
            //3.write(char[],int,int)
            fileWriter.write(ch, 0, 1);
            //3.write(String)
            fileWriter.write(s);
            //4.write(String,int,int)
            fileWriter.write(s, 0, 3);
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //对于fileWriter 只有close或flush后，才能成功写入。
            //writeBytes()方法才正真写入数据
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
