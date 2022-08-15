package 项目.坦克大战._2版本.tankgame2;

import java.util.Vector;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 8:34
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
@SuppressWarnings({"all"})
public class Enemy extends Tank implements Runnable{    //为了实现自由移动，做成线程
    //为敌方坦克分配弹夹
    Vector<Bullet> bullets = new Vector<>();
    int bulletSize = 2;
    //是否存活
    private boolean isLive = true;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
    @Override
    public void run() {
        while(isLive){
            int direction = getDirection();
            switch (direction){
                case 0:
                    /*一个方向上移动几步*/
                    for (int i = 0; i < 30; i++) {
                        if(getY() - getSpeed() >= 0){
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //发射子弹
                    if(bullets.size() < bulletSize){
                        Bullet bullet = new Bullet(getX() + 20, getY(), direction);
                        bullets.add(bullet);
                        new Thread(bullet).start();
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if(getX() + getSpeed() + 60 <= 1000){
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bullets.size() < bulletSize){
                        Bullet bullet = new Bullet(getX() + 60, getY() + 20, direction);
                        bullets.add(bullet);
                        new Thread(bullet).start();
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if(getY() + getSpeed() + 60 <= 750){
                            moveDown();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(bullets.size() < bulletSize){
                        Bullet bullet = new Bullet(getX() + 20, getY() + 60, direction);
                        bullets.add(bullet);
                        new Thread(bullet).start();
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if(getX() - getSpeed()>= 0){
                            moveLeft();
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(bullets.size() < bulletSize){
                        Bullet bullet = new Bullet(getX(), getY() + 20, direction);
                        bullets.add(bullet);
                        new Thread(bullet).start();
                    }
                    break;
            }
            //随机方向  (int)(Math.random()*4)
            setDirection((int)(Math.random()*4));
        }
    }
}
