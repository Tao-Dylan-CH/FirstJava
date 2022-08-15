package 第3部分._4反射._2Class类;

import java.io.Serializable;

/**
 * @author 挚爱之夕
 * @date 2021-12-17 - 12 - 17 - 14:55
 * @Description 第3部分._2反射._2Class类
 * @Version 1.0
 */
public class _3所有具有Class对象的类型 {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;      //外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Integer[]> cls3 = Integer[].class;//数组
        Class<int[][]> cls4 = int[][].class;//数组
        Class<Thread.State> cls5 = Thread.State.class;//枚举
        Class<Integer> cls6 = int.class; //基本类型
        Class<Void> cls7 = void.class;   //void
        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
    }
}
