package 第3部分._4反射._2Class类;

import reflection.Cat;

/**
 * @author 挚爱之夕
 * @date 2021-12-16 - 12 - 16 - 22:31
 * @Description 第3部分._2反射._2Class类
 * @Version 1.0
 */
public class _2获取Class类 {
    public static void main(String[] args) throws Exception{
        //1 Class.forName()
        Class<?> cls1 = Class.forName("reflection.Cat");

        //2 全类名.class
        Class<Cat> cls2 = Cat.class;

        //3 对象名.getClass()
        Cat cat = new Cat();
        Class<? extends Cat> cls3 = cat.getClass();

        //4 类加载器.getClass()
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass("reflection.Cat");

        //5.基本类型，获取Class对象
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
        Class<Boolean> booleanClass = boolean.class;

        //6.基本类型对应的包装类，获取Class对象
        Class<Integer> integerClass1 = Integer.TYPE;
        System.out.println(integerClass1);
    }
}
