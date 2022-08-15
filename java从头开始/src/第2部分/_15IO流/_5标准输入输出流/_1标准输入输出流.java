package 第2部分._15IO流._5标准输入输出流;

import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/12/4 - 12 - 04 - 23:07
 * @Description 第2部分._15IO流._5标准输入输出流
 * @Version 1.0
 */
public class _1标准输入输出流 {
    public static void main(String[] args) {
        /*
        标准输入流 in，从键盘读入
        public final static InputStream in = null;
        in 编译类型 InputStream      运行类型 BufferedInputStream
         */
        System.out.println(System.in.getClass());
        Scanner scanner = new Scanner(System.in);
        /*
        标准输出流 out，输出到显示器
        public final static PrintStream out = null;
        out 编译类型 PrintStream    运行类型 PrintStream
         */
        System.out.println(System.out.getClass());
    }
}
