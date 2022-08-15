package 项目.坦克大战._2版本.tankgame4;

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
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌方坦克
    Vector<Enemy> enemies = new Vector<>();
    int enemySize = 5;
    //定义炸弹集，用于显示爆炸效果，子弹击中坦克，加入一颗炸弹
    Vector<Bomb> bombs = new Vector<>();
    //定义在场全体坦克
    Vector<Tank> tanks = new Vector<>();
    //三张图片，显示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanel(int choice){
        if(choice == 1){  //继续上局
            Recorder.readRecord();
            hero = Recorder.getHero();
            enemies = Recorder.getEnemies();
            tanks = Recorder.getTanks();
        }else{              //开始新游戏
            //初始化我方坦克
            hero = new Hero(450, 600);
            hero.setSpeed(5);
            //设置hero可以访问所有坦克信息，用于判断坦克是否相撞
            hero.setTanks(tanks);
            //添加到所有坦克集
            tanks.add(hero);
            //赋予记录信息类所有坦克信息
            Recorder.setEnemies(enemies);
            Recorder.setHero(hero);
            //初始化敌方坦克
            for (int i = 0; i < enemySize; i++) {
                Enemy enemy = new Enemy((100 * (i + 1)), 0);
                //enemy对象可以访问所有坦克信息,用于判断坦克是否相撞
                enemy.setTanks(tanks);
                //敌方坦克初始方向向下
                enemy.setDirection(2);
                //启动敌方坦克线程
                new Thread(enemy).start();
                //创建子弹
                Bullet bullet = new Bullet(enemy.getX() + 20, enemy.getY() + 60, enemy.getDirection());
                //为敌方坦克分配一颗子弹
                enemy.bullets.add(bullet);
                //启动敌方子弹线程
                new Thread(bullet).start();
                this.enemies.add(enemy);
                //添加到所有坦克集
                tanks.add(enemy);
            }
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb3.png"));

        //播放音乐
        new AePlayWave("src/111.wav").start();
    }
    //显示玩家信息
    public void showInfo(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体", Font.BOLD, 25));
        g.drawString("当前击毁坦克数量", 1020, 30);
        drawTank(1020, 60, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getDefeatedTanks() + "", 1080, 100);
    }
    @Override
    public void paint(Graphics g) {
        //调用父类方法，完成初始化
        super.paint(g);
        //游戏背景
        g.fillRect(0, 0, 1000, 750);
        //显示玩家信息
        showInfo(g);
        //画我方坦克
        if(hero.isLive()){
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        }else{
            g.setColor(Color.red);
            g.setFont(new Font("隶书", Font.BOLD, 30));
            g.drawString("Game Over!", 400, 400);
            return;
        }
        if(enemies.size() == 0){
            g.setColor(Color.red);
            g.setFont(new Font("隶书", Font.BOLD, 30));
            g.drawString("You Win!", 400, 400);
            return;
        }
        //画敌方坦克、子弹
//        for (Enemy enemy : enemies) {
//            if(enemy.isLive()) {
//                //画敌方坦克
//                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
//                //画敌方坦克的每一个子弹
//                for (Bullet bullet : enemy.bullets
//                ) {
//                    if (bullet.isLive()) {
//                        g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
//                    } else {
//                        enemy.bullets.remove(bullet); //不能再遍历时删除元素
//                    }
//                }
//            }
//        }
        //画敌方坦克、子弹
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            //坦克存活才绘制   击中就已经移除，可以不判断
//            if(enemy.isLive()) {
                //画敌方坦克
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
                //画敌方坦克的每一个子弹
                for (int j = 0; j < enemy.bullets.size(); j++) {
                    Bullet bullet = enemy.bullets.get(j);
                    if (bullet.isLive()) {
                        g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
                    } else {    //敌方坦克子弹消亡，移除
                        enemy.bullets.remove(bullet);
                    }
                }
//            }
        }
        //画我方坦克子弹
//        if (hero.getBullet() != null && hero.getBullet().isLive()) {    //单发
//            Bullet bullet = hero.getBullet();
//            g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
//        }
        for (int i = 0; i < hero.bullets.size(); i++) { //多发
            Bullet bullet = hero.bullets.get(i);
            if(bullet != null && bullet.isLive()){
                g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
            }else{
                hero.bullets.remove(bullet);
            }
        }

        //显示爆炸效果，炸弹集中有炸弹就画
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            int life = bomb.life;
            if(life > 6){   //大图
                g.drawImage(image1, bomb.x, bomb.y + 5, this);
            }else if(life > 3){ //中图
                g.drawImage(image2, bomb.x, bomb.y + 10, this);
            }else{  //小图
                g.drawImage(image3, bomb.x + 5, bomb.y + 20, this);
            }
            //减少bomb生命值
            bomb.lifeDown();
            //bomb生命周期结束，从bombs中移除
            if(!bomb.isLive){
                bombs.remove(bomb);
            }
        }
    }

    /**
     * @param x      坦克x坐标
     * @param y      坦克y坐标
     * @param g      画笔
     * @param direct 坦克方向 0-up 1-right 2-down 3- left
     * @param type   坦克类型    0-1
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据坦克类型，绘制不同颜色的坦克
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克方向，绘制坦克
        switch (direct) {

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
                g.fill3DRect(x, y + 30, 60, 10, false);
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
                g.fill3DRect(x, y + 30, 60, 10, false);
                //矩形盖子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                //圆形盖子
                g.fillOval(x + 20, y + 10, 20, 20);
                //炮筒
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    /***
     * 该方法放在run()方法里，当我方子弹没有消失
     * 判断是否击中敌方坦克
     * @param bullet    我方子弹
     * @param tank     敌方坦克
     */
//    public void hitEnemy(Bullet bullet, Enemy enemy) {
//        int direction = enemy.getDirection();
//        //子弹坐标
//        int bulletX = bullet.getX();
//        int bulletY = bullet.getY();
//        //敌方坦克坐标
//        int enemyX = enemy.getX();
//        int enemyY = enemy.getY();
//        switch (direction) {
//            case 0:
//            case 2:
//                //击中敌方坦克
//                if (bulletX > enemyX && bulletX < enemyX + 40 && bulletY > enemyY && bulletY < enemyY + 60) {
//                    bullet.setLive(false);
//                    enemy.setLive(false);
//                    bombs.add(new Bomb(enemyX, enemyY));
//                    enemies.remove(enemy);
//                }
//                break;
//            case 1:
//            case 3:
//                if (bulletX > enemyX && bulletX < enemyX + 60 && bulletY > enemyY && bulletY < enemyY + 40) {
//                    bullet.setLive(false);
//                    enemy.setLive(false);
//                    bombs.add(new Bomb(enemyX, enemyY));
//                    enemies.remove(enemy);
//                }
//                break;
//        }
//    }

    /**
     * 判断敌方坦克子弹是否击中我方坦克
     * 我方坦克子弹是否击中敌方坦克
     * @param bullet 子弹
     * @param tank  坦克
     */
    public void hitTank(Bullet bullet, Tank tank) {
        int direction = tank.getDirection();
        //子弹坐标
        int bulletX = bullet.getX();
        int bulletY = bullet.getY();
        //坦克坐标
        int tankX = tank.getX();
        int tankY = tank.getY();
        switch (direction) {
            case 0:
            case 2:
                //击中坦克
                if (bulletX > tankX && bulletX < tankX + 40 && bulletY > tankY && bulletY < tankY + 60) {
                    bullet.setLive(false);
                    //向下转型
                    if(tank instanceof Enemy){
                        ((Enemy)tank).setLive(false);
                        enemies.remove(tank);
                        tanks.remove(tank);
                        //记录击败坦克数量加一
                        Recorder.addNumber();
                    }else if(tank instanceof Hero){
                        ((Hero) tank).setLive(false);
                    }
                    bombs.add(new Bomb(tankX, tankY));

                }
                break;
            case 1:
            case 3:
                if (bulletX > tankX && bulletX < tankX + 60 && bulletY > tankY && bulletY < tankY + 40) {
                    bullet.setLive(false);
                    if(tank instanceof Enemy){
                        ((Enemy)tank).setLive(false);
                        enemies.remove(tank);
                        tanks.remove(tank);
                        //记录击败坦克数量加一
                        Recorder.addNumber();
                    }else if(tank instanceof Hero){
                        ((Hero) tank).setLive(false);
                    }
                    bombs.add(new Bomb(tankX, tankY));
                }
                break;
        }
    }
    /*判断我方子弹是否击中敌方坦克*/
    public void hitEnemies(){
        /*每一颗子弹都判断是否击中敌方坦克*/
        for (int i = 0; i < hero.bullets.size(); i++) {
            Bullet bullet = hero.bullets.get(i);
            if(bullet != null && bullet.isLive()){
                for (int j = 0; j < enemies.size(); j++) {
                    hitTank(bullet, enemies.get(j));
                }
            }
        }
    }

    public void hitHero(){
        for (int i = 0; i < enemies.size(); i++) {
            //敌方坦克
            Enemy enemy = enemies.get(i);
            //敌方坦克弹夹
            Vector<Bullet> bullets = enemy.bullets;
            //判断敌方坦克的每一颗子弹是否击中我方坦克
            for (int j = 0; j < bullets.size(); j++) {
                hitTank(bullets.get(j), hero);
            }
        }
    }
//    public boolean heroCanMove(){
//        for(Enemy enemy : enemies){
//            if(!canMove(hero, enemy)){
//                return false;
//            }
//        }
//        return true;
//    }
//    public boolean canMove(Tank tank1, Tank thank2){
//        int x1 = tank1.getX();
//        int x2 = thank2.getX();
//        int y1 = tank1.getY();
//        int y2 = thank2.getY();
//        int direction = thank2.getDirection();
//        int l1 = tank1.getSpeed();
//        int l2 = thank2.getSpeed();
//        switch (direction){
//            case 0:
//            case 2:
//                if((y1 > y2 + 60 && y1 - l1 < y2 + 60)&&(x1> x2 && x1 < x2 + 40)){
//                    return false;
//                }
//                break;
//            case 1:
//            case 3:
//                if((x1 > x2 && x1 < x2 + 60) && (y1 > y2 + 40 && y1 + l1 < y2 + 40)){
//                    return false;
//                }
//                break;
//        }
//        return true;
//    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /*监听坦克移动    w-d-s-a     up-right-down-left*/
    @Override
    public void keyPressed(KeyEvent e) {
        boolean touchAnotherTank = hero.isTouchAnotherTank();
        //监听坦克移动
        int keyCode = e.getKeyCode();
//        System.out.println("hero:" + hero.getX() + "," + hero.getY());
        if (keyCode == KeyEvent.VK_W) {
            hero.setDirection(0);
            if(hero.getY() - hero.getSpeed() >= 0  && !touchAnotherTank){
                hero.moveUp();
            }
        } else if (keyCode == KeyEvent.VK_D ) {
            hero.setDirection(1);
            if(hero.getX() + hero.getSpeed() + 60 <= 1000 && !touchAnotherTank){
                hero.moveRight();
            }
        } else if (keyCode == KeyEvent.VK_S ) {
            hero.setDirection(2);
            if(hero.getY() + hero.getSpeed() + 60 <=  750&& !touchAnotherTank){
                hero.moveDown();
            }
        } else if (keyCode == KeyEvent.VK_A ) {
            hero.setDirection(3);
            if(hero.getX() - hero.getSpeed() >= 0&& !touchAnotherTank){
                hero.moveLeft();
            }
        }
        //监听坦克射击
        if (keyCode == KeyEvent.VK_J) {
//            System.out.println("开始射击...");
            //每次只发射一颗子弹，子弹消亡后才能发射
//            if(hero.getBullet() == null || !hero.getBullet().isLive()){
//                hero.shoot();
//            }
            //发射多颗子弹
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
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
            判断我方子弹是否击中坦克
            注意加上：hero.getBullet()!= null
            不然未发射子弹，会抛出空指针异常
             */
//            if (hero.getBullet() != null && hero.getBullet().isLive()) {
//                //不用foreach循环，应为遍历时不能删除元素
////                for (Enemy enemy : enemies) {
////                    hitEnemy(hero.getBullet(), enemy);
////                }
//                for (int i = 0; i < enemies.size(); i++) {
//                    hitEnemy(hero.getBullet(), enemies.get(i));
//                }
//            }
            hitEnemies();
            hitHero();
            this.repaint();
        }
    }
}
