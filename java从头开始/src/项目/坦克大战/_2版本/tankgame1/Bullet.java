package 项目.坦克大战._2版本.tankgame1;

/**
 * @author 挚爱之夕
 * @date 2021/11/27 - 11 - 27 - 9:05
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
public class Bullet implements Runnable {
    private int x;  //子弹x坐标
    private int y;  //子弹y坐标
    private int direction = 0;
    private int speed = 2;
    private boolean isLive = true;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(direction == 0){
                y -= speed;
            }else if(direction == 1){
                x += speed;
            }else if(direction == 2){
                y += speed;
            }else if(direction == 3){
                x -= speed;
            }
            System.out.println("子弹 x:" + x + " y:" + y);
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)){
                System.out.println("子弹进程结束");
                break;
            }
        }
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
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
