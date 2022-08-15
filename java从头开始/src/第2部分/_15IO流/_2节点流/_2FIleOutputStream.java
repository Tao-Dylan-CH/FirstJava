package 第2部分._15IO流._2节点流;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 22:27
 * @Description 第2部分._15IO流._2输入输出流
 * @Version 1.0
 */
public class _2FIleOutputStream {
    public static void main(String[] args) {

    }
    @Test
    void method(){
        FileOutputStream fileOutputStream = null;
        try {
            /*
            构造方法：
            1.new FileOutputStream("D:/hello.txt")  覆盖
            2.new FileOutputStream("D:/hello.txt", true)    追加
            */
            fileOutputStream = new FileOutputStream("D:/hello.txt", true);
            //1.write()写入一个字节
            fileOutputStream.write('h');
            fileOutputStream.write('e');
            fileOutputStream.write('l');
            fileOutputStream.write('l');
            fileOutputStream.write('o');
            //2.write(byte[] b) 写入多个字节
            String str = "I'm Harry Potter.";
            //String 转 byte数组
            fileOutputStream.write(str.getBytes());
            //3.write(byte[] b, int off, int len)
            fileOutputStream.write(str.getBytes(), 4, 5);
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
