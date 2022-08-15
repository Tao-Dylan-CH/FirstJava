package 项目.坦克大战._1准备;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 22:36
 * @Description 项目.坦克大战._1准备
 * @Version 1.0
 */
public class _3事件监听 {
    /*
    移动小球
     */
    public static void main(String[] args) {
        new MyFrame();
    }
    static class MyFrame extends JFrame{
        MyPanel panel = null;
        public MyFrame(){
            panel = new MyPanel();
            setSize(500, 300);
            add(panel);
            addKeyListener(panel);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    static class MyPanel extends JPanel implements KeyListener {
        Ball ball = new Ball(20, 20, 10);
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.fillOval(ball.x, ball.y, ball.radius, ball.radius);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_UP){
                ball.y--;
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                ball.y++;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                ball.x--;
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                ball.x++;
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    static class Ball{
        int x;
        int y;
        int radius;
        public Ball(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
