package 第2部分._9异常;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 21:16
 * @Description 第2部分._9异常
 * @Version 1.0
 */
public class _2Demo {
    public static void main(String[] args) {

    }
    //1.try-catch
    //2.throws  可抛出多个异常，可以是其异常的父类
    public void f1() throws FileNotFoundException, NullPointerException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:test.txt");
    }
}
