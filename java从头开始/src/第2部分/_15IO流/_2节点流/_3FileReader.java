package 第2部分._15IO流._2节点流;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 23:08
 * @Description 第2部分._15IO流._2输入输出流
 * @Version 1.0
 */
public class _3FileReader {
    public static void main(String[] args) {

    }
    //每次读取一个字符
    @Test
    void method1(){
        FileReader fileReader = null;
        int c ;
        try {
            fileReader = new FileReader("D:/1.txt");
            while((c = fileReader.read()) != -1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //每次读取一个字符数组
    @Test
    void method2(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("D:/1.txt");
            char[] buf = new char[32];
            int dataLen = 0;
            while((dataLen = fileReader.read(buf)) != -1){
                System.out.print(new String(buf, 0, dataLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
