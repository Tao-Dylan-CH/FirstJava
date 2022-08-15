package 第3部分._4反射;

import java.lang.reflect.Field;

/**
 * @author 挚爱之夕
 * @date 2021-12-19 - 12 - 19 - 9:31
 * @Description 第3部分._4反射
 * @Version 1.0
 */
public class _2通过反射操作属性 {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("reflection.Cat");
        Object o = aClass.newInstance();
        //1.得到公有属性
        Field name = aClass.getField("name");
        System.out.println(name.get(o));
        System.out.println("set后：");
        name.set(o, "大白");
        System.out.println(name.get(o));
        //2.得到任意声明属性
        Field count = aClass.getDeclaredField("count");//这个属性是静态、私有的
        count.setAccessible(true);//爆破
        System.out.println(count.get(o));
        count.set(o, 100);
        count.set(null, 100);   //因为是静态的，与对象无关，可以为null
        System.out.println(count.get(o));
        System.out.println(count.get(null));  //静态的，可以为null
    }
}
