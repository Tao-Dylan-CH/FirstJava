package 第2部分._9异常;

import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 18:20
 * @Description 第2部分._9异常
 * @Version 1.0
 */
public class _1循环输入直到输入整数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        boolean loop = true;
        int n = 0;
        while(true){
            try {
                System.out.println("请输入整数：");
                 n = Integer.parseInt(scanner.nextLine());
//                loop = false;
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的不是整数！");
            }
        }
        System.out.println("输入的整数是：" + n);
    }
}

