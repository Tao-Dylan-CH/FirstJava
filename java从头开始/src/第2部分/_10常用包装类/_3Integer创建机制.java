package 第2部分._10常用包装类;

/**
 * @author 挚爱之夕
 * @date 2021/11/15 - 11 - 15 - 8:25
 * @Description 第2部分.常用包装类
 * @Version 1.0
 */
public class _3Integer创建机制 {
    public static void main(String[] args) {
        /*
        自动装箱调用的是Integer类的valueOf方法

        public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
        -128 - 127 之间返回的是Integer类的静态对象
         */
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(1);
        System.out.println(integer1 == integer2);

        Integer integer3 = 1;
        Integer integer4 = 1;
        System.out.println(integer3 == integer4);

        Integer integer5 = 128;
        Integer integer6 = 128;
        System.out.println(integer5 == integer6);

        Integer integer = 128;
        int i = 128;
        //设计基本类型，比较值
        System.out.println(i == integer);
    }
}
