package 项目.坦克大战._2版本.tankgame2;

import java.util.Vector;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:31
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
@SuppressWarnings({"all"})
public class Hero extends Tank {
    private Bullet bullet = null;
    private boolean isLive = true;
    //发射多颗子弹：定义子弹集
    Vector<Bullet> bullets = new Vector<>();    //发射多颗子弹，相关代码
    /**
     * 发射子弹
     */
    public void shoot(){
        //同一时间只反射5颗
        if(bullets.size() >= 5){
            return;
        }
        int direction = getDirection();
        switch (direction){
            case 0:
                bullet = new Bullet(getX() + 20, getY(), direction);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, direction);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, direction);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, direction);
                break;
        }
        bullets.add(bullet);    //发射多颗子弹，相关代码

        new Thread(bullet).start();
    }
    public Hero(int x, int y) {
        super(x, y);
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }
}
