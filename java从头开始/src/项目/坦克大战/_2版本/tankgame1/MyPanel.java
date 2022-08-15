package 项目.坦克大战._2版本.tankgame1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:32
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
/*
    为了子弹具有移动效果，将MyPanel做成一个线程
 */

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable{
    //定义我的坦克
    Hero hero = null;
    //定义敌方坦克
    Vector<Enemy> enemies = new Vector<>();
    int enemySize = 3;
    public MyPanel(){
        //初始化我方坦克
        hero = new Hero(450, 600);
        hero.setSpeed(3);
        //初始化敌方坦克
        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy((100 * (i + 1)), 0);
            //敌方坦克初始方向向下
            enemy.setDirection(2);
            this.enemies.add(enemy);
        }

    }

    @Override
    public void paint(Graphics g) {
        //调用父类方法，完成初始化
        super.paint(g);
        //游戏背景
        g.fillRect(0, 0, 1000, 750);
        //画我方坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        //画敌方坦克
        for (Enemy enemy : enemies) {
            //画敌方坦克
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
        }
        //画子弹
        if(hero.getBullet() != null){
            Bullet bullet = hero.getBullet();
//            g.fill3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
            g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
        }
    }

    /**
     *
     * @param x 坦克x坐标
     * @param y 坦克y坐标
     * @param g 画笔
     * @param direct   坦克方向 0-up 1-right 2-down 3- left
     * @param type  坦克类型    0-1
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type){
        //根据坦克类型，绘制不同颜色的坦克
        switch (type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向，绘制坦克
        switch (direct){

            case 0:
                /*向上*/
                //左轮
                g.fill3DRect(x, y, 10, 60, false);
                //右轮
                g.fill3DRect(x + 30, y, 10, 60, false);
                //矩形盖子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                //圆形盖子
                g.fillOval(x + 10, y + 20, 20, 20);
                //炮筒
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;

            case 1:
                /*向右*/
                //上轮
                g.fill3DRect(x, y, 60, 10, false);
                //下轮
                g.fill3DRect(x , y + 30, 60, 10, false);
                //矩形盖子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                //圆形盖子
                g.fillOval(x + 20, y + 10, 20, 20);
                //炮筒
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                /*向下*/
                //左轮
                g.fill3DRect(x, y, 10, 60, false);
                //右轮
                g.fill3DRect(x + 30, y, 10, 60, false);
                //矩形盖子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                //圆形盖子
                g.fillOval(x + 10, y + 20, 20, 20);
                //炮筒
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                /*向左*/
                //上轮
                g.fill3DRect(x, y, 60, 10, false);
                //下轮
                g.fill3DRect(x , y + 30, 60, 10, false);
                //矩形盖子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                //圆形盖子
                g.fillOval(x + 20, y + 10, 20, 20);
                //炮筒
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    /*监听坦克移动    w-d-s-a     up-right-down-left*/
    @Override
    public void keyPressed(KeyEvent e) {
        //监听坦克移动
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_W){
            hero.setDirection(0);
            hero.moveUp();
        }else if(keyCode == KeyEvent.VK_D){
            hero.setDirection(1);
            hero.moveRight();
        }else if(keyCode == KeyEvent.VK_S){
            hero.setDirection(2);
            hero.moveDown();
        }else if(keyCode == KeyEvent.VK_A){
            hero.setDirection(3);
            hero.moveLeft();
        }
        //监听坦克射击
        if(keyCode == KeyEvent.VK_J){
            System.out.println("开始射击...");
            hero.shoot();
        }
        //重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
