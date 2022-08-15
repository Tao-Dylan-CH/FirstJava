package 第2部分._15IO流._6转换流;

import java.io.*;

/**
 * @author 挚爱之夕
 * @date 2021/12/4 - 12 - 04 - 23:29
 * @Description 第2部分._15IO流._6转换流
 * @Version 1.0
 */
public class _3OutputStreamWriter {
    public static void main(String[] args) {
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            //1.字符流 -> 处理流
            osw =new OutputStreamWriter(new FileOutputStream("D:/gbk.txt"), "gbk");
             bw = new BufferedWriter(osw);
             //2.可以 处理流 -> 字符流 但是没必要
//            bw.write("BufferedWriter");
            //2.写入
            osw.write("这是用转换流写入的gbk编码文件");
            System.out.println("使用转换流指定编码，写入文件成功！");
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //3.关闭最外层流
                osw.close();
//                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
