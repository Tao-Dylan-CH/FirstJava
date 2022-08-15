package 第1部分._7断点调试;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 10:48
 * @Description 第1部分._7断点调试
 * @Version 1.0
 */
public class _1Debug {
    /*演示逐行执行代码*/
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += i;
            System.out.println("i = "+i);
            System.out.println("sum = "+sum);
        }
        System.out.println("sum = "+ sum);
    }
}
