package 第3部分._4反射.作业;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 挚爱之夕
 * @date 2021-12-19 - 12 - 19 - 11:35
 * @Description 第3部分._4反射.作业
 * @Version 1.0
 */
public class 作业2 {
    /*
    使用反射
    得到File类的所有构造函数
    创建一个File对象
    保存File文件
     */
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("java.io.File");
        //所有构造器
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        //得到一个String参数的构造器
        Constructor<?> constructor = aClass.getConstructor(String.class);
        //得到一个File对象
        Object o = constructor.newInstance("E:/MyNew.txt");
        //得到File中的createNewFile()方法
        Method createNewFile = aClass.getMethod("createNewFile");
        //调用方法
        createNewFile.invoke(o);
    }
}
