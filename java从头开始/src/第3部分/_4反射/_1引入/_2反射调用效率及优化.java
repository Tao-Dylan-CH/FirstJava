package 第3部分._4反射._1引入;

import reflection.Cat;

import java.lang.reflect.Method;

/**
 * @author 挚爱之夕
 * @date 2021-12-16 - 12 - 16 - 16:45
 * @Description 第3部分._2反射
 * @Version 1.0
 */
public class _2反射调用效率及优化 {
    /*
    1.传统调用方法和反射机制调用方法的效率比较
    2.反射优化：关闭反射的访问检查，提高一些效率
     */
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
        /*

        传统用时: 48ms
        反射用时: 3236ms
        取消安全检查的反射用时: 835ms

         */
    }
    //传统方法
    private static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("传统用时: " + (end - start) + "ms");
    }
    //反射机制
    private static void m2() throws Exception {
        Class<?> cls = Class.forName("reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("反射用时: " + (end - start) + "ms");
    }
    //反射机制取消安全检查
    private static void m3() throws Exception {
        Class<?> cls = Class.forName("reflection.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true); //取消访问检查
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("取消安全检查的反射用时: " + (end - start) + "ms");
    }

}
