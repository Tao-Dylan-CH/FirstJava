package 第3部分._4反射;

import java.lang.reflect.Method;

/**
 * @author 挚爱之夕
 * @date 2021-12-19 - 12 - 19 - 9:45
 * @Description 第3部分._4反射
 * @Version 1.0
 */
public class _3通过反射获取方法 {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("reflection.Cat");
        Object o = aClass.newInstance();
        //1.获取公有方法
        Method mi = aClass.getMethod("mi", String.class);
        /*
            public String mi(String no){
                return no;
            }
         */
        //形参
        Class<?>[] parameterTypes = mi.getParameterTypes();
        System.out.println("形参类型：");
        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType.getSimpleName());
        }
        //返回值
        System.out.println("返回值类型：");
        System.out.println(mi.getReturnType());
        System.out.println("调用方法：");
        //方法调用
        System.out.println(mi.invoke(o, "1110"));
        System.out.println("----------------------");
        //2.获取任意声明方法
        Method birthday = aClass.getDeclaredMethod("birthday", int.class, int.class, int.class);
        /*
            private static String birthday(int y, int m, int d){
                return y + " " + m + " " + d;
            }
         */
        birthday.setAccessible(true);   //爆破
        System.out.println("形参类型：");
        //形参
        Class<?>[] parameterTypes1 = birthday.getParameterTypes();
        for (Class<?> aClass1 : parameterTypes1) {
            System.out.println(aClass1.getSimpleName());
        }
        //返回值
        System.out.println("返回值类型：");
        System.out.println(birthday.getReturnType().getSimpleName());
        //方法调用
        System.out.println("方法调用：");
        System.out.println(birthday.invoke(o, 2000, 1, 1));
        System.out.println(birthday.invoke(null, 2021, 3, 9));  //静态，可不传对象
        //方法返回值 统一返回Object 运行类型和实际方法返回值类型一致
        Object invoke = birthday.invoke(null, 2021, 12, 19);
        System.out.println(invoke);
        System.out.println("返回值类型： " + invoke.getClass());
    }
}
