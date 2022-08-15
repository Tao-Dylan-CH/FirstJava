package 第2部分._15IO流.模拟处理流设计模式;

/**
 * @author 挚爱之夕
 * @date 2021/12/2 - 12 - 02 - 15:42
 * @Description 第2部分._15IO流.模拟处理流设计模式
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        MyBufferedReader myBufferedReader = new MyBufferedReader(new MyFileReader());
        myBufferedReader.readFiles(2);
        MyBufferedReader myBufferedReader1 = new MyBufferedReader(new MyStringReader());
        myBufferedReader1.readStrings(2);
    }
}
