package 第3部分._4反射._1引入;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2021-12-16 - 12 - 16 - 16:13
 * @Description 第3部分._2反射
 * @Version 1.0
 */
public class _1反射演示 {
    /*
    演示反射获取
    对象
    方法
    字段
    构造器
     */
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/cat.properties"));
        String classFullName = properties.get("classFullName").toString();
        String methodName = properties.get("method").toString();

        //1.获取对应的Class对象
        Class<?> cls = Class.forName(classFullName);

        //2.获取对应的对象实例
        Object o = cls.newInstance();

        //3.获取方法对象
        Method method = cls.getMethod(methodName);
        //调用方法
        //反射机制：方法.invoke(对象)
        method.invoke(o);

        //4.获取成员属性对象
        //反射机制：字段.get(对象)

        //getField()方法 得到共有属性,不能得到私有方法
        Field nameFiled = cls.getField("name");
        System.out.println("name属性：" + nameFiled);
        System.out.println("name内容：" + nameFiled.get(o));

        //5.获取构造器对象
        Constructor<?> constructor = cls.getConstructor();  //无参构造器
        System.out.println("无参构造器： " + constructor);
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println("一个String类型的构造器： " + constructor1);
    }
}
