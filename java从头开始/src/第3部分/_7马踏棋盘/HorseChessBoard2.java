package 第3部分._7马踏棋盘;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 18:05
 * @Description 马踏棋盘:使用贪心算法，选择下一步时，选择下一步的下一步选择最少的，减少回溯
 * @Version 1.0
 */
@SuppressWarnings({"all"})
public class HorseChessBoard2 {
    private static int x = 6;//棋盘列数
    private static int y = 6;//棋盘行数
    private static int[][] chessBoard = new int[y][x];//棋盘
    private static boolean[] visited = new boolean[x * y];//记录马是否走过
    private static boolean finished = false;
    public static void main(String[] args) {
        int row = 2;
        int col = 2;
        long start = System.currentTimeMillis();
        traversalChessBord(chessBoard, row - 1, col - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + " ms");
        for(int[] rows : chessBoard){
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }

    }

    /**
     *
     * @param curPoint 当前马的位置
     * @return 当前可走位置
     */
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point();
        //5号 位置
        if((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0){
            points.add(new Point(p));
        }
        //6号 位置
        if((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0){
            points.add(new Point(p));
        }
        //7号 位置
        if((p.x = curPoint.x + 1) < x && (p.y = curPoint.y - 2) >= 0){
            points.add(new Point(p));
        }
        //0号 位置
        if((p.x = curPoint.x + 2) < x && (p.y = curPoint.y - 1) >= 0){
            points.add(new Point(p));
        }
        //1号 位置
        if((p.x = curPoint.x + 2) < x && (p.y = curPoint.y + 1) < y){
            points.add(new Point(p));
        }
        //2号 位置
        if((p.x = curPoint.x + 1) < x && (p.y = curPoint.y + 2) < y){
            points.add(new Point(p));
        }
        //3号 位置
        if((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < y){
            points.add(new Point(p));
        }
        //4号 位置
        if((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < y){
            points.add(new Point(p));
        }

        return points;
    }
    public static void traversalChessBord(int[][] chessBoard, int row, int col, int step){
        chessBoard[row][col] = step;
        visited[row * x + col] = true;
        ArrayList<Point> points = next(new Point(col , row));//x对应col,y对应row
        sort(points);//贪心，排序
        while(!points.isEmpty()){
            Point point = points.remove(0);
            if(!visited[point.y * x + point.x]){
                traversalChessBord(chessBoard, point.y, point.x, step+1);
            }
        }
        if(step < x * y && !finished){//回溯
            chessBoard[row][col] = 0;
            visited[row * x + col] = false;
        }else{
            finished = true;
        }
    }

    /**
     * 对下一步可走位置进行排序，根据其下一步可走位置数升序排序
     * @param points 下一步可走位置
     */
    public static void sort(ArrayList<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
}
