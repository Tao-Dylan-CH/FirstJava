package 第2部分._10常用包装类;

/**
 * @author 挚爱之夕
 * @date 2021/11/15 - 11 - 15 - 8:11
 * @Description 第2部分.常用包装类
 * @Version 1.0
 */
public class _2包装类型和String类型的转换 {
    public static void main(String[] args) {
        Integer integer = 1;
        //包装类转字符串
        //方式1
        String s = integer.toString();
        //方式2
        s = integer + "";
        //方式3
        s = String.valueOf(integer);

        //字符串到包装类
        String s1 = "123";
        //方式1
        Integer integer1 = Integer.getInteger(s1);
        integer1 = new Integer(s1);
    }
}
