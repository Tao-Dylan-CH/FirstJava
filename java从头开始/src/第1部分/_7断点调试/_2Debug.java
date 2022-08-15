package 第1部分._7断点调试;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 10:59
 * @Description 第1部分._7断点调试
 * @Version 1.0
 */
public class _2Debug {
    /*看一下数组越界异常*/
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        for (int i = 0; i <= a.length; i++) {
            System.out.println("a["+i+"] = "+a[i]);
        }
        System.out.println("Exit the for loop");
    }
}
