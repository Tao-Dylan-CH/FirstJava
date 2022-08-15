package 项目.坦克大战._1准备;

import javax.swing.*;
import java.awt.*;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 18:30
 * @Description 项目.坦克大战._1准备
 * @Version 1.0
 */
public class _2画个坦克 {
    public static void main(String[] args) {
        new DrawTank();
    }
    static class DrawTank extends JFrame {
        MyPanel panel = null;
        public DrawTank(){
            this.setBackground(Color.black);
            panel = new MyPanel();
            setSize(500, 400);
            add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }
    static class MyPanel extends Panel{
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.fillRect(0, 0 , 500, 400);
            g.setColor(Color.YELLOW);
            int x = 100, y = 100;
            g.fill3DRect(x, y, 10, 60, false);
            g.fill3DRect(x+30, y, 10, 60, false);
            g.fill3DRect(x+10, y+10, 20, 40, false);
            g.fillOval(x+10, x+20, 20, 20);
            g.drawLine(x+20, y+20, x+20, y);
        }
    }
}
