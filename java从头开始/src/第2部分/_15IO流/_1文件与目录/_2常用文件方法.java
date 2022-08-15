package 第2部分._15IO流._1文件与目录;

import java.io.File;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 11:19
 * @Description 第2部分._15文件
 * @Version 1.0
 */
public class _2常用文件方法 {
    public static void main(String[] args) {
        File file = new File("D:/file1.txt");
        System.out.println("file name:" + file.getName());
        System.out.println("file size(bite):" + file.length());
        System.out.println("file parent:" + file.getParent());
        System.out.println("file absolute path:" + file.getAbsolutePath());
        System.out.println("is file:" + file.isFile());
        System.out.println("is directory:" + file.isDirectory());
        System.out.println("is exist:" + file.exists());
    }
}
