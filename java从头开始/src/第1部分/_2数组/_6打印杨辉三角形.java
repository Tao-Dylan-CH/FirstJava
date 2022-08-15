package 第1部分._2数组;

/**
 * @author 挚爱之夕
 * @date 2021/11/4 - 11 - 04 - 23:17
 * @Description 第1部分._2数组
 * @Version 1.0
 */
public class _6打印杨辉三角形 {
    private static void print(int n){
        int[][] a = new int[n][];
        //创建二维数组
        for (int i = 0; i < n; i++) {
            a[i] = new int[i+1];
            for (int j = 0; j < i + 1; j++) {
                if(j == 0||i == j){
                    a[i][j] = 1;
                }else{
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
                }
            }
        }
        //输出
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print(10);
    }
}
