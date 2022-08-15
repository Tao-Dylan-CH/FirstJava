package 第3部分._4反射.作业;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 挚爱之夕
 * @date 2021-12-19 - 12 - 19 - 11:22
 * @Description 第3部分._4反射.作业
 * @Version 1.0
 */
public class 作业1 {
    /*
    通过反射创建对象
    通过反射修改对象属性值
    通过反射得到对象属性值
     */
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("reflection.PrivateTest");
        Object o = aClass.newInstance();
        //得到成员属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(o));
        //设置name
        name.set(o, "Harry Potter");
        //字段内容
        System.out.println(name.get(o));
        //调用getName方法得到字段内容
        Method getName = aClass.getMethod("getName");
        System.out.println(getName.invoke(o));
    }
}
