package 项目.坦克大战._2版本.tankgame1;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:31
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
public class Hero extends Tank{
    private Bullet bullet = null;

    public void shoot(){
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
}
