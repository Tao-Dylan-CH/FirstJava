package 项目.零钱通系统.面向过程;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 15:22
 * @Description 项目.零钱通系统.面向对象
 * @Version 1.0
 */
public class SmallChangeSystem {
    /*1.先完成显示菜单，并可以选择菜单，给出对应提示*/
    public static void main(String[] args) {
        //定义相关变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        /*2.完成零钱通明细*/
        //1.数组  2.使用对象  3.字符串拼接

        String details = "----------零钱通明细----------";

        /*3.完成收益入账*/
        double money = 0;
        double balance = 0; //余额
        Date date;  //日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");   //用于日期格式化
        /*4.完成消费明细*/
        String note = "";
        /*5.退出逻辑*/
        String choice = "";
        do {
            System.out.println("\n==========零钱通菜单==========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退   出");

            System.out.println("请选择（1-4）：");
            key = scanner.next();


            //使用switch 分支控制
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("输入收益入账金额：");
                    money = scanner.nextDouble();
                    //效验money的值是否合理
                    if(money <= 0){
                        System.out.println("收益金额应为大于0");
                        break;
                    }
                    balance += money;
                    //拼接收益入账信息
                    date = new Date();  //获取当前日期
                    details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.println("输入消费金额：");
                    money = scanner.nextDouble();
                    //范围效验
                    if(money <= 0 || money > balance){
                        System.out.println("你的消费金额应该在[1-"+balance+"]");
                        break;
                    }
                    balance -= money;
                    System.out.println("请输入消费说明：");
                    note = scanner.next();
                    date = new Date();
                    details += "\n" + note + "\t" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    do {
                        System.out.println("你确定要退出吗？(y,n)");
                        choice = scanner.next();
                    } while (!choice.equals("y") && !choice.equals("n"));
                    if(choice.equals("y")){
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择。");

            }
        } while (loop);
        System.out.println("----------退出了零钱通系统----------");
    }
}
