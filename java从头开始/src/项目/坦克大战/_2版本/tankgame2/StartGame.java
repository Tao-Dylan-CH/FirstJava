package 项目.坦克大战._2版本.tankgame2;

/**
 * @author 挚爱之夕
 * @date 2021/11/25 - 11 - 25 - 21:35
 * @Description 项目.坦克大战._2版本.tankgame1
 * @Version 1.0
 */
public class StartGame {
    /*
    版本2：
    功能：
    1.我方坦克可以移动，并且发射一颗子弹
    2.敌方坦克可以发射子弹
    3.我方子弹击中坦克，坦克爆炸
    4.敌方坦克随机移动
    5.坦克移动边界控制
    6.我方坦克一次发射一颗子弹，子弹消亡后才能再发射
    7.我方坦克可以发射多颗子弹(可以控制屏幕中同时存在我方子弹数)
    8.敌方可每次发射指定数量的子弹
    9.我方坦克被击中爆炸
    新增功能：
    2.敌方坦克可以发射子弹
    给敌方坦克添加存放Bullet的vector
    初始化添加一颗子弹，并启动子弹线程
    3.我方子弹击中坦克，坦克爆炸
    panel的run中判断我方子弹是否击中敌方坦克
    击中坦克设置死亡，并从敌人集中移除
    创建Bomb类，根据死亡坦克的坐标生成一个Bomb类
    在paint中绘制，三张图片展示爆炸效果，图片由大到小
    4.敌方坦克随机移动
    将敌方坦克做成线程，run方法中在一个方向移动休眠重复多次，
    之后随机改变方向
    5.坦克移动边界控制
    移动时判断是否越界
    6.我方坦克一次发射一颗子弹，子弹消亡后才能再发射
    按下J键时，判断子弹是否消亡
    7.我方坦克可以发射多颗子弹(可以控制屏幕中同时存在我方子弹数)
    hero中添加子弹集，每次创建子弹，都加入集合，pain中遍历子弹，存在绘制，不存在从集中移除
    另外需要修改panel的run中判断子弹击中坦克的功能，改为遍历子弹集(可以创建一个方法)
    8.敌方可每次发射指定数量的子弹
    Enemy中添加bulletSize属性，指定面板中一个敌方单位的子弹数
    Enemy的run方法中判断，子弹数小于指定子弹数，创建子弹添加到弹夹，并启动子弹线程
    panel中pain方法，已经判断子弹不存活,则移除
    9.我方坦克被击中爆炸
    给hero添加属性isLive
    panel的run 方法中判断敌方坦克子弹是否击中我方坦克，击中isLive设为false
    panel的pain 方法中判断我方坦克是否存活，存活才画
     */
    public static void main(String[] args) {
        new MyFrame();
    }
}
