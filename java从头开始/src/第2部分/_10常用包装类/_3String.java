package 第2部分._10常用包装类;

/**
 * @author 挚爱之夕
 * @date 2021/11/15 - 11 - 15 - 8:57
 * @Description 第2部分.常用包装类
 * @Version 1.0
 */
public class _3String {
    public static void main(String[] args) {
        //两种创建方式
        String a = "12";
        String b = "12";
        System.out.println(a.equals(b));//T
        System.out.println(a == b);//T

        String a1 = "23";
        String b1 = new String("23");
        System.out.println(a1.equals(b1));  //T
        System.out.println(a1 == b1);//F
        System.out.println(a1 == b1.intern());//T
        System.out.println(a1 == a1.intern());//T
    }
}
