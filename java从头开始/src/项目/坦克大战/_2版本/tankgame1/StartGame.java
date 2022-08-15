package 项目.坦克大战._2版本.tankgame1;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:35
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
public class StartGame {
    /*
    版本1：
    1.我方坦克可以移动，并且发射一颗子弹
    面板实现KeyListener接口监听键盘事件
    按下w-d-s-a改变坦克坐标
    面板实现Runnable接口每休眠100ms重绘面板
    创建Bullet类实现Runnable
    Hero类添加Bullet属性
    监听j按下，启动一个子弹线程
    2.敌方坦克无法移动，无法发射子弹
     */
    public static void main(String[] args) {
        new MyFrame();
    }
}
