package 第1部分._3类与对象._1递归;

/**
 * @author 挚爱之夕
 * @date 2021/11/5 - 11 - 05 - 16:16
 * @Description 第1部分._3类与对象._1递归
 * @Version 1.0
 */
public class _1猴子吃桃 {
    public static void main(String[] args) {
        int total = Monkey.peach(1);
        System.out.println("第一天，桃子的个数为：" + total);
    }
}
class Monkey{
    static int peach(int n){
        if(n == 10){
            return 1;
        }else if(1 <= n && n < 10){
            return 2*(peach(n+1)+1);
        }else{
            System.out.println("只能计算1-10天，桃子的个数。");
            return -1;
        }
    }
}
