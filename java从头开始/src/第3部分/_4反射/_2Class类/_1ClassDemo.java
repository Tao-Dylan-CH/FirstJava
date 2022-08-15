package 第3部分._4反射._2Class类;

import java.lang.reflect.Field;

/**
 * @author 挚爱之夕
 * @date 2021-12-16 - 12 - 16 - 21:37
 * @Description 第3部分._2反射._2Class类
 * @Version 1.0
 */
public class _1ClassDemo {
    public static void main(String[] args) throws Exception{
        //1.得到class对象
        Class<?> cls = Class.forName("reflection.Cat");
        //2.得到cat对象
        Object o = cls.newInstance();
        //3.得到包名
        System.out.println("包名：" + cls.getPackage().getName());
        //4.得到全类名
        System.out.println("全类名：" + cls.getName());
        //5.得到属性
        Field name = cls.getField("name");
        System.out.println("属性：" + name.get(o));
        //6.给属性赋值
        name.set(o, "tom");
        System.out.println("赋值后，属性：" + name.get(o));
        //6.遍历字段
        Field[] fields = cls.getFields();
        System.out.println("所有共有字段");
        for (Field field:fields
             ) {
            System.out.println(field.getName()+" : "+field.get(o));
        }
    }
}
