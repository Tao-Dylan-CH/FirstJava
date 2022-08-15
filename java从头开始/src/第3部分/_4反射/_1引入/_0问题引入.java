package 第3部分._4反射._1引入;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2021-12-16 - 12 - 16 - 15:05
 * @Description 第3部分._2反射._1引入
 * @Version 1.0
 */
public class _0问题引入 {
    /*
    根据配置文件 cat.properties 指定信息，创建Cat对象并调用指定方法

    classFullPath=reflection.Cat

    method=hi   配置文件设置不同method实现不同的效果

    现有技术如何实现？
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/cat.properties"));
        String classFullName = properties.get("classFullName").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classFullPath:" + classFullName);
        System.out.println("method:" + methodName);
        //1.传统创建对象
        reflection.Cat cat = new reflection.Cat();
        cat.hi();
        //2.当我们无法用得到的字符串创建对象

        //new classFullName();
        System.out.println("-----反射-----");
        //3.通过反射机制

        //加载类，得到类Class 类型的对象cls
        Class<?> cls = Class.forName(classFullName);
        System.out.println("通过全类名的得到的Class: " + cls);
        //通过cls 得到对象实例
        Object o = cls.newInstance();
        System.out.println("通过cls得到的实例对象： " + o);
        //通过cls 得到方法对象
        Method method = cls.getMethod(methodName);
        //通过方法对象method 实现调用方法
        System.out.print("调用cat方法 " + methodName +": ");
        method.invoke(o);   //传统调用：对象.方法()  反射机制：方法对象.invoke(对象)

        /*
        调用不同方法，只需要修改配置文件，而不需要修改源码
         */
    }
}
