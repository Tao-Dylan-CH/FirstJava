package 项目.坦克大战._2版本.tankgame2;

/**
 * @author 挚爱之夕
 * @date 2021/11/28 - 11 - 28 - 15:43
 * @Description 项目.坦克大战._2版本.tankgame2
 * @Version 1.0
 */

/*
炸弹
子弹击中坦克时显示爆炸效果
 */
public class Bomb {
    int x;
    int y;
    boolean isLive = true;
    int life = 9;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){
        if(life>0){
            life--;
        }else{
            isLive = false;
        }
    }
}
