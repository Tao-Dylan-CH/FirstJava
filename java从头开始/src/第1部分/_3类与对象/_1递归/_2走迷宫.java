package 第1部分._3类与对象._1递归;

/**
 * @author 挚爱之夕
 * @date 2021/11/5 - 11 - 05 - 19:28
 * @Description 第1部分._3类与对象._1递归
 * @Version 1.0
 */
public class _2走迷宫 {
    /**
     * 1.先创建一个二维数组，表示迷宫：int[][] map = new int[8][7]
     * 2.先规定 map 数组的元素值：0表示可以走、1表示障碍物
     * 1	1	1	1	1	1	1
     * 1	0	0	0	0	0	1
     * 1	0	1	0	0	0	1
     * 1	1	1	0	0	0	1
     * 1	0	0	0	0	0	1
     * 1	0	0	0	0	0	1
     * 1	0	0	0	0	0	1
     * 1	1	1	1	1	1	1
     */
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //3.将最上面的一行和最下面一行，全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //将最左和最右列，赋值为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;


        map[2][2] = 1;

        //老鼠走迷宫
        Mouse mouse = new Mouse();
        mouse.findWay(map, 1, 1);
        System.out.println("\n找路情况如下：");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
class Mouse{
    /**
     * 递归找出出路
     * @param map 迷宫
     * @param i 当前位置行号，初始为1
     * @param j 当前位置列号，初始为1
     * @return 找到路返回true，否则返回false
     * 数组值规定：0 表示可以走、1 表示障碍物、2 假定可以走、3 表示走不通
     * 当map[6][5] = 2 说明找到通路，否则继续找
     * 先判断老鼠找路策略 下->右->上->左
     */
    public boolean findWay(int[][] map, int i, int j){
        if(map[6][5] == 2){//已经找到
            return true;
        }else{
            if(map[i][j] == 0){ //说明可以走
                //假定可以走通
                map[i][j] = 2;
                //使用走路策略，来确定该位置能否真的走通
                if(findWay(map, i+1, j)){   //先右
                    return true;
                }else if(findWay(map, i, j+1)){//向下
                    return true;
                }else if(findWay(map, i-1, j)){//向左
                    return true;
                }else if(findWay(map, i, j-1)){//向上
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{  //1, 2, 3
                return false;
            }
        }
    }
}
