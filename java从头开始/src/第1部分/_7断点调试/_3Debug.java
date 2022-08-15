package 第1部分._7断点调试;

import java.util.Arrays;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 11:56
 * @Description 第1部分._7断点调试
 * @Version 1.0
 */
public class _3Debug {
    /*
    演示追踪源码
    看看java设计者是如何实现的
    提高编程思想
     */
    public static void main(String[] args) {
        int[] a = {1,0,3,10,2};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
    }
}
