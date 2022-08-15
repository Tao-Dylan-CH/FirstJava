package 第2部分._15IO流.模拟处理流设计模式;

/**
 * @author 挚爱之夕
 * @date 2021/12/2 - 12 - 02 - 15:37
 * @Description 第2部分._15IO流.模拟处理流设计模式
 * @Version 1.0
 */

/*
处理流
 */
public class MyBufferedReader extends MyReader{
    private MyReader in;

    public MyBufferedReader(MyReader in) {
        this.in = in;
    }
    //多次读取文件
    public void readFiles(int num){
        for (int i = 0; i < num; i++) {
            in.readFile();
        }
    }
    //多次读取字符串
    public void readStrings(int num){
        for (int i = 0; i < num; i++) {
            in.readString();
        }
    }
}
