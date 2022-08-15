package 第2部分._15IO流.作业;

import java.io.*;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 11:17
 * @Description 第2部分._15IO流.作业
 * @Version 1.0
 */
public class 作业02 {
    /*
    使用BufferedRead读取文件内容
    一次读一行,添加行号
    输出到显示屏
     */
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:/Student.txt"));
//        String line;
//        int lineNum = 1;
//        while((line = bufferedReader.readLine()) != null){
//            System.out.println((lineNum++) + " " +line);
//        }
        /*
        要求指定编码"gbk"读取
         */
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("D:/Student.txt"), "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int lineNum = 1;
        while((line = bufferedReader.readLine()) != null){
            System.out.println(lineNum++ + " " + line);
        }
    }
}
