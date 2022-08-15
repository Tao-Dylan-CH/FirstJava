package 项目.坦克大战._2版本.tankgame4;

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
    private int bulletSize = 2;
    //是否存活
    private boolean isLive = true;
    //在MyPanel中通过set方法赋值，获取在场所有坦克
    Vector<Tank> tanks = null;
    public Enemy(int x, int y) {
        super(x, y);
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    /**
     * 防止坦克重叠
     * @return  true-可以移动   false-不能移动
     */
    public boolean isTouchAnotherTank(){
        //得到当前坦克方向
        int direction = this.getDirection();
        //考虑当前坦克的四个方向
        switch (direction){
            case 0:
                //和其他坦克比较，是否发生碰撞
                for (int i = 0; i < tanks.size(); i++) {
                    Tank anotherTank = tanks.get(i);
                    //不比较自己
                    if(!(anotherTank == this)){
                        //对方向上向下等价，向左向右等价
                        int anotherDirection = anotherTank.getDirection();
                        //对方x 和 y
                        int x = anotherTank.getX();
                        int y = anotherTank.getY();
                        //对方向上向下
                        if(anotherDirection == 0 || anotherDirection == 2){
                            //判断我方左上角和右上角是否与对方碰撞
                            //左上角:(getX(),getY())
                            if(getX() >= x && getX() <= x + 40 && getY() >= y && getY() <= y +60 ){
                                return true;
                            }
                            //右上角:(getX()+40,getY())
                            //只需要getX()+40即可
                            if(getX()+40 >= x && getX()+40 <= x + 40 && getY() >= y && getY() <= y +60 ){
                                return true;
                            }
                        }
                        //对方向左向右
                        //这里实际上只需修改上面的x最大值为x+60，y最大值为y+40即可
                        if(anotherDirection == 1||anotherDirection == 3){
                            //判断我方左上角和右上角是否与对方碰撞
                            //左上角:(getX(),getY())
                            if(getX() >= x && getX() <= x + 60 && getY() >= y && getY() <= y + 40){
                                return true;
                            }
                            //右上角:(getX()+40,getY())
                            if(getX()+40 >= x && getX()+40 <= x + 60 && getY() >= y && getY() <= y + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < tanks.size(); i++) {
                    Tank anotherTank = tanks.get(i);
                    if(!(anotherTank == this)){
                        int anotherDirection = anotherTank.getDirection();
                        int x = anotherTank.getX();
                        int y = anotherTank.getY();
                        /*
                        我方方向：右
                        右上角(x+60,y)
                        右下角(x+60,y+40)
                         */
                        if(anotherDirection == 0 || anotherDirection == 2){
                            if(getX()+60 >= x && getX()+60 <= x + 40 && getY() >= y && getY() <= y + 60){
                                return true;
                            }
                            if(getX()+60 >= x && getX()+60 <= x + 40 && getY() + 40 >= y && getY() + 40 <= y + 60){
                                return true;
                            }
                        }
                        if(anotherDirection == 1 || anotherDirection == 3){
                            if(getX()+60 >= x && getX()+60 <= x + 60 && getY() >= y && getY() <= y +40){
                                return true;
                            }
                            if(getX()+60 >= x && getX()+60 <= x + 60 && getY() + 40 >= y && getY() + 40 <= y +40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < tanks.size(); i++) {
                    Tank anotherTank = tanks.get(i);
                    if(!(anotherTank == this)){
                        int anotherDirection = anotherTank.getDirection();
                        int x = anotherTank.getX();
                        int y = anotherTank.getY();
                        /*
                        我方方向：下
                        左下角(x,y+60)
                        右下角(x+40,y+60)
                         */
                        if(anotherDirection == 0 || anotherDirection == 1){
                            if(getX() >= x && getX() <= x + 40 && getY()+60 >= y && getY()+60 <= y +60){
                                return true;
                            }
                            if(getX()+40 >= x && getX()+40 <= x + 40 && getY()+60 >= y && getY()+60 <= y +60){
                                return true;
                            }
                        }
                        if(anotherDirection == 2 || anotherDirection == 3){
                            if(getX() >= x && getX() <= x + 60 && getY()+60 >= y && getY()+60 <= y +40){
                                return true;
                            }
                            if(getX()+40 >= x && getX()+40 <= x + 60 && getY()+60 >= y && getY()+60 <= y +40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < tanks.size(); i++) {
                    Tank anotherTank = tanks.get(i);
                    if(!(anotherTank == this)){
                        int anotherDirection = anotherTank.getDirection();
                        int x = anotherTank.getX();
                        int y = anotherTank.getY();
                        /*
                        我方方向：左
                        左上角(x,y)
                        左下角(x,y+40)
                         */
                        if(anotherDirection == 0 || anotherDirection == 2){
                            if(getX() >= x && getX() <= x+40 && getY() >= y && getY() <= y+60){
                                return true;
                            }
                            if(getX() >= x && getX() <= x+40 && getY()+40 >= y && getY()+40 <= y+60){
                                return true;
                            }
                        }
                        if(anotherDirection == 1 || anotherDirection == 3){
                            if(getX() >= x && getX() <= x+60 && getY() >= y && getY() <= y+40){
                                return true;
                            }
                            if(getX() >= x && getX() <= x+60 && getY()+40 >= y && getY()+40 <= y+40){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }

    public void setTanks(Vector<Tank> tanks) {
        this.tanks = tanks;
    }

    @Override
    public void run() {
        while(isLive){
            int direction = getDirection();
            switch (direction){
                case 0:
                    /*一个方向上移动几步*/
                    for (int i = 0; i < 30; i++) {
                        if(getY() - getSpeed() >= 0 && !isTouchAnotherTank()){
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
                        if(getX() + getSpeed() + 60 <= 1000 && !isTouchAnotherTank()){
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
                        if(getY() + getSpeed() + 60 <= 750 && !isTouchAnotherTank()){
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
                        if(getX() - getSpeed()>= 0 && !isTouchAnotherTank()){
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
