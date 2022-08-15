package 项目.零钱通系统.面向对象;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 22:18
 * @Description 项目.零钱通系统.面向对象
 * @Version 1.0
 */


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP（面向对象编程）
 * 将各个功能对应一个方法
 */
public class SmallChangeSystemOOP {
    //mainMenu 是否循环
    private boolean loop = true;
    private final Scanner scanner = new Scanner(System.in);
    //字符串拼接
    private String details = "----------零钱通明细----------";

    //单笔金额
    private double money = 0;
    //余额
    private double balance = 0;
    //日期
    private Date date;
    //日期格式化
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //主菜单
    public void mainMenu(){
        do {
            System.out.println("\n==========零钱通菜单(OOP)==========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退   出");

            System.out.println("请选择（1-4）：");
            String key = scanner.next();


            //使用switch 分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择。");

            }
        } while (loop);
        System.out.println("----------退出了零钱通系统----------");
    }

    //金额明细
    public void detail(){
        System.out.println(details);
    }

    //收入
    public void income(){
        System.out.println("输入收益入账金额：");
        money = scanner.nextDouble();
        //效验money的值是否合理
        if(money <= 0){
            System.out.println("收益金额应为大于0");
            return;
        }
        balance += money;
        //拼接收益入账信息
        date = new Date();  //获取当前日期
        details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    //消费
    public void pay(){
        System.out.println("输入消费金额：");
        money = scanner.nextDouble();
        //范围效验
        if(money <= 0 || money > balance){
            System.out.println("你的消费金额应该在[1-"+balance+"]");
            return;
        }
        balance -= money;
        System.out.println("请输入消费说明：");
        /*4.完成消费明细*/
        String note = scanner.next();
        date = new Date();
        details += "\n" + note + "\t" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    //退出
    public void exit(){
        /*5.退出逻辑*/
        String choice = "";
        do {
            System.out.println("你确定要退出吗？(y,n)");
            choice = scanner.next();
        } while (!choice.equals("y") && !choice.equals("n"));
        if(choice.equals("y")){
            loop = false;
        }
    }
}
