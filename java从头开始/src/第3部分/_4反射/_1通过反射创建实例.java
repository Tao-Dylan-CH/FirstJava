package 第3部分._4反射;

import java.lang.reflect.Constructor;

/**
 * @author 挚爱之夕
 * @date 2021-12-19 - 12 - 19 - 8:51
 * @Description 第3部分._4反射._4通过反射创建实例
 * @Version 1.0
 */
public class _1通过反射创建实例 {
    public static void main(String[] args) throws Exception{
        //1.得到类的Class对象
        Class<?> catClass = Class.forName("reflection.Cat");
        //2.调用公有无参构造
        Object cat1 = catClass.newInstance();
        System.out.println(cat1);
        //3.得到公有构造器，创建实例
        Constructor<?> cat2Constructor = catClass.getConstructor(String.class);
        Object cat2 = cat2Constructor.newInstance("大白");
        System.out.println(cat2);
        //4.得到任意修饰符修饰的构造器,无权访问的需要爆破
        Constructor<?> catClassDeclaredConstructor =
                catClass.getDeclaredConstructor(String.class, int.class);
        catClassDeclaredConstructor.setAccessible(true);//爆破（暴力破解），使反射可以调用私有构造
        Object cat3 = catClassDeclaredConstructor.newInstance("小黑", 3);
        System.out.println(cat3);
    }
}
