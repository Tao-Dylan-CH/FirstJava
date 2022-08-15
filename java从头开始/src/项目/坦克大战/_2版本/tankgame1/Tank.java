package 项目.坦克大战._2版本.tankgame1;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:31
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
public class Tank {
    private int x;
    private int y;
    private int direction;
    private int speed;
    /*坦克移动： 0-up    1-right     2-down  3-left*/

    public void moveUp(){
        y -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
