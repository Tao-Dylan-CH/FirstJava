package 第2部分._15IO流.作业;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 11:01
 * @Description 第2部分._15IO流.作业
 * @Version 1.0
 */
public class 作业01 {
    /*
    在判断e盘下是否有文件夹myTemp ,如果没有就创 myTemp
    在e:\\myTemp 目录下, 创建文件 hello.txt
    如果hello.txt 已经存在，提示该文件已经存在，就不要再重复创建了
     */
    public static void main(String[] args) {
        File directory = new File("E:/myTemp");
        if(!directory.exists()){
            if(directory.mkdirs()){
                System.out.println(directory.getName() + "目录创建成功！");
            }else{
                System.out.println(directory.getAbsolutePath() + "目录创建失败！");
            }
        }else{
            System.out.println(directory.getAbsolutePath() + "目录已经存在");
        }
        File file = new File(directory, "hello.txt");
        if(!file.exists()){
            try {
                if(file.createNewFile()){
                    System.out.println(file.getAbsolutePath() + "文件创建成功！");
                }else{
                    System.out.println(file.getAbsolutePath() + "文件创建失败！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(file.getAbsolutePath() + "文件已经存在");
        }
        //向文件写入内容
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("hello word");
            System.out.println(file.getName() + "写入内容成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
