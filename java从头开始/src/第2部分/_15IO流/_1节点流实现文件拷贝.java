package 第2部分._15IO流;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 22:58
 * @Description 第2部分._15IO流
 * @Version 1.0
 */
public class _1节点流实现文件拷贝 {
    //字节流
    @Test
     void copyFileByBite() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        String srcFilePath = "D:/bridge.jpg";
        String desFilePath = "E:/bridge.jpg";
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(desFilePath);
            byte[] buff = new byte[1024];
            int dataLen = 0;
            while ((dataLen = fileInputStream.read(buff)) != -1) {
                fileOutputStream.write(buff, 0, dataLen);
            }
            System.out.println("字节流，复制文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //字符流
    @Test
    void copyFileByChar(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        String srcFilePath = "D:/1.txt";
        String desFilePath = "F:/copy1.txt";
        try {
            fileReader = new FileReader(srcFilePath);
            fileWriter = new FileWriter(desFilePath);
            char[] data = new char[1024];
            int dataLength;
            while((dataLength = fileReader.read(data)) != -1){
                fileWriter.write(data, 0, dataLength);
            }
            System.out.println("字符流，复制文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileReader != null){
                    fileReader.close();
                }
                if(fileWriter != null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
