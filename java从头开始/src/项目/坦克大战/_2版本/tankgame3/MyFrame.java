package 项目.坦克大战._2版本.tankgame3;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:35
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
@SuppressWarnings({"all"})
public class MyFrame extends JFrame {
    MyPanel panel = null;

    public MyFrame(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("----------坦克大战小游戏----------");
        System.out.println("1.继续上局游戏");
        System.out.println("2.重新开始游戏");
        System.out.println("3.退出游戏");
        while(true){
            choice = readInt();
            if(choice == 1){
                this.panel = new MyPanel(1);
                break;
            }else if(choice == 2){
                this.panel = new MyPanel(2);
                break;
            }else if(choice == 3){
                return;
            }else{
                System.out.println("输入有误，请重新输入：");
            }
        }
        setSize(1000 + 15 + 250, 750 + 45);
//        this.setResizable(false);
        add(panel); //将面板加入窗口
        new Thread(panel).start();        //启动面板线程
        addKeyListener(panel);  //窗口监听面板事件
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
            }
        });
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
