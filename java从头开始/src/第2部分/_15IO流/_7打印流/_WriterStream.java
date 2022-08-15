package 第2部分._15IO流._7打印流;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 9:54
 * @Description 第2部分._15IO流._7打印流
 * @Version 1.0
 */
public class _WriterStream {
    /*
    字符输出流
    WriterStream Demo
     */
    public static void main(String[] args) throws IOException {
        //
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(111);
        printWriter.close();
        PrintWriter print = new PrintWriter(new FileWriter("D:/WriterStream.txt"));
        print.println("WriterStream");
        print.close();
    }
}
