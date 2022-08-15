package 项目.坦克大战._1准备;

import javax.swing.*;
import java.awt.*;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 16:56
 * @Description 项目.坦克大战._1准备
 * @Version 1.0
 */
public class _1绘图 {
    public static void main(String[] args) {
        new DrawOval();
    }
    static class DrawOval extends JFrame{
        //定义一个面板
        MyPanel myPanel = null;
        public DrawOval(){
            myPanel = new MyPanel();    //初始化面板
            this.add(myPanel);  //将面板加入窗口
            this.setSize(400 , 300);
            this.setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    /*
    1.MyPanel 对象是一个画板
    2.Graphics g g可以理解为一只画笔
    3.Graphics 提供了很多绘图的方法
     */
    static class MyPanel extends JPanel{
        //当组件第一次在屏幕显示的时,程序会自动调用paint()方法来绘制组件
        @Override
        public void paint(Graphics g) { //画图方法
            super.paint(g); //调用父类的方法，完成初始化
            //画椭圆
            g.drawOval(10, 10, 100, 90);
            //画直线
            g.drawLine(1, 1, 100, 100);
            //画矩形
            g.drawRect(100, 100, 100, 50);
            //画填充矩形
            g.fillRect(0, 100, 50, 50);
            //画填充椭圆
            g.setColor(new Color(0, 150, 250));//改变画笔颜色
            g.fillOval(0, 150, 50, 50);
            //画图片
            /*  /b.png表示从项目的根目录获取图片资源 即out目录下 的 java从头开始     */
//            Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/b.png"));
//            g.drawImage(image, 0, 0, 1444, 804, this);
            //画字符串
            g.setColor(Color.blue);
            g.setFont(new Font("隶书", Font.BOLD, 30));
            g.drawString("Hello GUI!", 100, 20);    //对应字符串，坐标是左下角

        }
    }
}
