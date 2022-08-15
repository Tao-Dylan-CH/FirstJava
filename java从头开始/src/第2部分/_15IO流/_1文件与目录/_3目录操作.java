package 第2部分._15IO流._1文件与目录;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author 挚爱之夕
 * @date 2021/12/1 - 12 - 01 - 11:26
 * @Description 第2部分._15文件
 * @Version 1.0
 */
public class _3目录操作 {
    public static void main(String[] args) {
//        InputStream

    }
    //删除文件：D:/file1.txt
    @Test
    void method1(){
        File file = new File("D:/file1.txt");
        if(file.exists()){
            if (file.delete()) {
                System.out.println("Deleting a file succeeded.");
            }else{
                System.out.println("Failed to delete a file.");
            }
        }else{
            System.out.println("File does not exist.");
        }
    }
    //删除目录：D:E
    //在java编程中目录也视为文件
    @Test
    void method2(){
        File file = new File("D:/E");
        if(file.exists()){
            if(file.delete()){
                System.out.println("Deleting a directory succeeded.");
            }else{
                System.out.println("Failed to delete a file.");
            }
        }else{
            System.out.println("Directory does not exist.");
        }
    }
    //创建目录 D:E
    @Test
    void method3(){
        File file = new File("D:/E");
        if(file.exists()){
            System.out.println("Directory already exists.");
        }else{
            if (file.mkdir()) {
                System.out.println("Creating a directory succeeded.");
            } else {
                System.out.println("Failed to create a directory.");
            }
        }
    }
}
