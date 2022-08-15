package 第2部分._15IO流;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 挚爱之夕
 * @date 2021/12/2 - 12 - 02 - 16:18
 * @Description 第2部分._15IO流
 * @Version 1.0
 */

public class _2处理流实现文件拷贝 {
    //字节流
    @Test
    private static void copyFileByByte(){
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("F:/轻衣.png"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:/轻衣.png"));
            byte[] data = new byte[1024];
            int dataLength;
            while((dataLength = bufferedInputStream.read(data)) != -1){
                bufferedOutputStream.write(data, 0, dataLength);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if(bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //字符流
    @Test
    void copyFileByChar(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String srcFilePath = "D:/1.txt";
        String desFilePath = "F:/buffCopy.txt";
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(desFilePath));
//            char[] data = new char[1024];
//            int dataLength;
//            while((dataLength = bufferedReader.read(data)) != -1){
//                bufferedWriter.write(data, 0, dataLength);
//            }
            //使用readLine() 读取一行内容，不读取换行符
            String line;
            while((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line); //写入一行
                bufferedWriter.newLine();   //换行
            }
            System.out.println("缓存流复制文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
