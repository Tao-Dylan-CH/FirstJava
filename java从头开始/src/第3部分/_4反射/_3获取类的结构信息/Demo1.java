package 第3部分._4反射._3获取类的结构信息;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 挚爱之夕
 * @date 2021-12-18 - 12 - 18 - 21:54
 * @Description 第3部分._2反射._3获取类的结构信息
 * @Version 1.0
 */
public class Demo1 {
    /*
    包
    类
    构造器
     */
    @Test
    void method1() throws Exception{
        Class<?> cls = Class.forName("reflection.Derived");
        String name = cls.getName();
        System.out.println("包名： " + cls.getPackage().getName());
        System.out.println("全类名： " + cls.getName());
        System.out.println("类名：" + cls.getSimpleName());
        Constructor<?>[] constructors = cls.getConstructors();
        System.out.println("公有构造器：");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("所有构造器：");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }
    /*
    方法
     */
    @Test
    void method2() throws Exception{
        Class<?> cls = Class.forName("reflection.Derived");
        System.out.println("本类及父类的公有方法名：");
        //本类和父类的所有public 修饰的方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        //本类中的所有方法
        Method[] declaredMethods = cls.getDeclaredMethods();
        System.out.println("本类的所有方法名：");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
    }
    /*
    属性
     */
    @Test
    void method3()throws Exception{
        Class<?> cls = Class.forName("reflection.Derived");
        Field[] fields = cls.getFields();
        System.out.println("本类及父类的所有公有字段名：");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("本类所有字段名:");
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field:declaredFields
             ) {
            System.out.println(field.getName());
        }
    }
    /*
    父类
    注解
    接口
     */
    @Test
    void method4()throws Exception{
        Class<?> cls = Class.forName("reflection.Derived");
        System.out.println("父类：");
        Class<?> superclass = cls.getSuperclass();
        System.out.println(superclass);
        System.out.println("注解：");
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println("实现的接口：");
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }
    /*
    Filed:
    修饰符值
    类型
     */
    @Test
    void method5() throws Exception{
        Class<?> cls = Class.forName("reflection.Derived");
        Field[] fields = cls.getDeclaredFields();
        System.out.println();
        System.out.println("所有字段：");
        for (Field field : fields) {
            System.out.println(field.getName());
            /*
            默认：0
            public:1
            protect:2
            private:3
            static:8
            final:16
             */
            System.out.println("修饰符值：" + field.getModifiers());
            System.out.println("类型: " + field.getType().getName());
        }
    }
    /*
    Method:
    修饰符值
    返回类型
    方法名
    参数类型数组
     */
    @Test
    void method6() throws Exception{
        Class<?> cls = Class.forName("reflection.Derived");
        //本类中的所有方法
        Method[] declaredMethods = cls.getDeclaredMethods();
        System.out.println("本类的所有方法名：");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
            System.out.println("返回类型： " + declaredMethod.getReturnType());
            System.out.println("方法名：" + declaredMethod.getName());
            System.out.println("参数类型数组： ");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }
        }
    }
}
