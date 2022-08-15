package 项目.坦克大战._1准备;

import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/28 - 11 - 28 - 15:16
 * @Description 项目.坦克大战._1准备
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int n = readInt();
        System.out.println("n =" + n);
    }
    static int readInt(){
        Scanner scanner = new Scanner(System.in);
        int res;
        String str;
        while(true){
            System.out.println("输入一个整数：");
            str = scanner.next();
            try{
                res = Integer.parseInt(str);
                return res;
            }catch (Exception e){
                System.out.println("输入错误！");
            }
        }
    }
}
