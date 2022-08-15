package 第1部分._3类与对象._2函数;

/**
 * @author 挚爱之夕
 * @date 2021/11/5 - 11 - 05 - 22:05
 * @Description 第1部分._3类与对象
 * @Version 1.0
 */
public class _1可变参数 {
    public static void main(String[] args) {
        System.out.println(f(1,2,3,4));
        f1("老王", 1,2,3,4);
    }
    //变长参数本质是数组
    private static int f(int...nums){
        int sums = 0;
        for (int i = 0; i < nums.length; i++) {
            sums += nums[i];
        }
        return sums;
    }
    //变长参数与普通参数混搭，但可变参数必须在最后
    private static void f1(String t, int...nums){
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println(t + "一共有" + total + "元。");
    }
}
