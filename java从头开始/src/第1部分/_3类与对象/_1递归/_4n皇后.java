package 第1部分._3类与对象._1递归;

/**
 * @author 挚爱之夕
 * @date 2021/11/5 - 11 - 05 - 21:24
 * @Description 第1部分._3类与对象
 * @Version 1.0
 */
public class _4n皇后 {
    public static void main(String[] args) {
        solve(4);
        System.out.println(count);
    }
    //行、列
    static int n;
    //排法总数
    static int count=0;
    //rec[i] 第i行所放皇后所在列
    static int[] rec;
    private static int solve(int t){
        n=t;//行数
        rec = new int[n];//数组下标对应行数，数值对应列数，即该行皇后放在第几列
        dfs(0);//从0行开始排
        return count;
    }
    private static void dfs(int row){
        if(row == n){   //一种排法
            count++;
            return;
        }
        //依次尝试在某个列上放一个皇后
        for(int col = 0;col<n;col++){
            //这里可以认为是剪枝
            //这一行的这一列可以放
            if(check(row, col)){
                rec[row] = col;//标记
                dfs(row+1);//继续找下一行
                //rec[row] = 0;//恢复原状，这种解法这里是否恢复状态都行，为什么？
            }
        }
    }
    private static boolean check(int row,int col){
        for(int i = 0;i<row;i++){
            //同一列、在负对角线方向上相邻、在主对角线方向上相邻
            if(rec[i] == col||i+rec[i]==row+col||i-rec[i]==row-col){
                return false;
            }
        }
        return true;
    }
}
