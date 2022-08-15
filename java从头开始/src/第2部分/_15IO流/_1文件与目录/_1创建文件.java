package 第2部分._15IO流._1文件与目录;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 10:44
 * @Description 第2部分._15文件
 * @Version 1.0
 */
public class _1创建文件 {
    public static void main(String[] args) {

    }

    // 方式一：new File(string pathname)
    @Test
    void createFile1(){
        String filePath = "D:/file1.txt";
        File file = new File(filePath);
        try {
            //调用该方法才在磁盘创建文件
            file.createNewFile();
            System.out.println("file1.txt,文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  方式二：new File(File parent,String child)

    void createFile2(){
        File parent = new File("D:/");
        String child = "file2.txt";

        File file = new File(parent, child);
        try {
            file.createNewFile();
            System.out.println("file2.txt,文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  方式三：new File(string parent,String child)
    @Test
    void createFile3(){
        String parent = "D:/";
        String child = "file3.txt";
        File file = new File(parent, child);
        try {
            file.createNewFile();
            System.out.println("file3.txt,文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
