package 第2部分._10常用包装类;

/**
 * @author 挚爱之夕
 * @date 2021/11/15 - 11 - 15 - 7:54
 * @Description 第2部分.常用包装类
 * @Version 1.0
 */
public class _1装箱和拆箱 {
    public static void main(String[] args) {
        int i = 1;
        //手动装箱
        Integer integer = new Integer(i);
        //手动拆箱
        int j = integer.intValue();
        System.out.println(j);
        //自动装箱
        Integer integer1 = 3;
        //自动拆箱
        int k = integer1;
        System.out.println(k);
    }
}
