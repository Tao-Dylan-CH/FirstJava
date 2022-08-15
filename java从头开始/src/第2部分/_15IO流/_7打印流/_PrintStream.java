package 第2部分._15IO流._7打印流;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 9:27
 * @Description 第2部分._15IO流._7打印流
 * @Version 1.0
 */
public class _PrintStream {
    /*
    字节输出流
    PrintStream Demo
     */
    public static void main(String[] args) throws IOException {
        //默认输入到显示器
        PrintStream out = System.out;
        /*
        public final static PrintStream out = null;
         */

//        PrintStream print = new PrintStream(System.out);
        out.println("PrintStream!");
        /*
            public void println(String x) {
                synchronized (this) {
                    print(x);
                    newLine();
                }
            }

            public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);
            }
         */
        out.write("write()".getBytes());
        //可以更改System.out打印流的输出位置
        System.setOut(new PrintStream("D:/PrintStream.txt"));
        /*
        public static void setOut(PrintStream out) {
            checkIO();
            setOut0(out);
        }
        本地方法，底层c++
        private static native void setOut0(PrintStream out);
         */
        System.out.println("这是打印流输出的一串字符");
        out.print("打印成功！");
        out.close();
        System.out.close();
    }
}
