package 项目.我的尝试;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 22:48
 * @Description 项目
 * @Version 1.0
 */
public class MyAttempt {
    private final Scanner scanner = new Scanner(System.in);
    private boolean loop = true;
    private String details = "---------------明细---------------";
    private double balance;
    private double money;
    private Date date;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
    private String choice;
    public void mainMenu(){
        do{
            System.out.println("\n==========零钱通==========");
            System.out.println("1   明细");
            System.out.println("2   收入");
            System.out.println("3   消费");
            System.out.println("4   退出");
            System.out.println("请输入你的选择(1-4)：");
            String key = scanner.next();
            switch (key){
                case "1":
                    detail();
                    break;
                case "2":
                    income();
                    break;
                case "3":
                    pay();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入。");
                    break;
            }
        }while(loop);
    }
    public void detail(){
        System.out.println(details);
    }
    public void income(){
        System.out.println("输入金额：");
        money = scanner.nextDouble();
        if(money <= 0){
            System.out.println("金额应为正数。");
            return;
        }
        date = new Date();
        balance += money;
        details += "\n收益入账" + "\t" + money + "\t" + simpleDateFormat.format(date) + "\t" + balance;
    }
    public void pay(){
        System.out.println("输入金额：");
        money = scanner.nextDouble();
        if(money <= 0 || money > balance){
            System.out.println("消费金额非法，请检查。");
            return;
        }
        System.out.println("输入消费说明：");
        choice= scanner.next();
        balance -= money;
        date = new Date();
        details += "\n"+ choice + "\t" + money + "\t" + simpleDateFormat.format(date) + "\t" +balance;
    }
    public void exit(){
        do{
            System.out.println("你确认退出吗？（y/n）");
            choice = scanner.next();
        }while(!choice.equals("y")&&!choice.equals("n"));
        if(choice.equals("y")){
            loop = false;
        }
    }
}
class Test{
    public static void main(String[] args) {
        new MyAttempt().mainMenu();
    }
}
