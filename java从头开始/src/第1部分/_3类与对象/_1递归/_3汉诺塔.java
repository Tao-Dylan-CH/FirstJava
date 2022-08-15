package 第1部分._3类与对象._1递归;

/**
 * @author 挚爱之夕
 * @date 2021/11/5 - 11 - 05 - 20:27
 * @Description 第1部分._3类与对象._1递归
 * @Version 1.0
 */
public class _3汉诺塔 {
    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.move(64,'A', 'B', 'C');
//        System.out.println();
//        HanoiTower.printHanoiTower(3,"A", "B", "C");
    }
}
class HanoiTower{
    public void move(int n, char from, char help, char to){
        if(n  == 1){
            System.out.println("move "+n+" from "+from + " to " + to);
        }else{
            //如果有多个盘，可以看成两个，最下面的和上面的所有盘

            //1.先移动n上面所有盘,借助目标柱，移动到辅助柱
            move(n - 1, from, to, help);
            //2.将n从原始柱移动到目标柱
            System.out.println("move "+n+" from "+from + " to " + to);
            //3.将辅助柱上所有的盘，借助原始柱，移动到目标柱
            move(n-1, help, from, to);
        }
    }
    static void printHanoiTower(int n,String from,String help,String to){
        if(n  == 1) {
            System.out.println("move " + n + " from " + from + " to " + to);
            return;
        }
        //如果有多个盘，可以看成两个，最下面的和上面的所有盘

        //1.先移动n上面所有盘,借助目标柱，移动到辅助柱
        printHanoiTower(n - 1, from, to, help);
        //2.将n从原始柱移动到目标柱
        System.out.println("move "+n+" from "+from + " to " + to);
        //3.将辅助柱上所有的盘，借助原始柱，移动到目标柱
        printHanoiTower(n-1, help, from, to);

    }
}
