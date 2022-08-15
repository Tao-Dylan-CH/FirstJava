package 项目.坦克大战._2版本.tankgame1;

import javax.swing.*;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:35
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
public class MyFrame extends JFrame {
    MyPanel panel = null;

    public MyFrame(){
        this.panel = new MyPanel();
        setSize(1000, 750);
        add(panel); //将面板加入窗口
        new Thread(panel).start();        //启动面板线程
        addKeyListener(panel);  //窗口监听面板事件
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
