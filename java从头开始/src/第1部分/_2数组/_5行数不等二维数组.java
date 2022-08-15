package 第1部分._2数组;

import java.util.Arrays;

/**
 * @author 挚爱之夕
 * @date 2021/11/4 - 11 - 04 - 23:09
 * @Description 第1部分._2数组
 * @Version 1.0
 */
public class _5行数不等二维数组 {
    public static void main(String[] args) {
        int[][] a = new int[3][];
        for (int i = 0; i < a.length; i++) {
            //每行为一个一维数组
            a[i] = new int[i+1];
            //为每行赋值
            for (int j = 0; j < i+1; j++) {
                a[i][j] = i+1;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
