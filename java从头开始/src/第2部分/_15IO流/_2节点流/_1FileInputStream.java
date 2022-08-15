package 第2部分._15IO流._2节点流;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 16:39
 * @Description 第2部分._15IO流._2输入输出流
 * @Version 1.0
 */
public class _1FileInputStream {
    //FileInputStream Demo
    public static void main(String[] args) {

    }
    /*
    演示read()方法
    一次读取一个字节
     */
    @Test
    void method1(){
        FileInputStream fileInputStream = null;
        String filePath = "D:/hello.txt";
        try {
            fileInputStream = new FileInputStream(filePath);
            int data ;
            //read()返回当前字符，遇到结尾返回-1
            while((data = fileInputStream.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    演示read(byte[] b)
    一次读取多个字节到b，提高效率
     */
    @Test
    void method2(){
        FileInputStream fileInputStream = null;
        byte[] b = new byte[8];
        int dataLength;
        try {
            fileInputStream = new FileInputStream("D:/hello.txt");
            while((dataLength = fileInputStream.read(b)) != -1){
                String s = new String(b, 0, dataLength);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
