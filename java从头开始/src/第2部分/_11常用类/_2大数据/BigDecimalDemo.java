package 第2部分._11常用类._2大数据;

import java.math.BigDecimal;

/**
 * @author 挚爱之夕
 * @date 2021/11/17 - 11 - 17 - 11:14
 * @Description 第2部分._11常用类._2大数据
 * @Version 1.0
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
//        double d = 99999999999999999999999999.9999991;
//        System.out.println(d);
        //当需要精度高的小数
        BigDecimal bigDecimal = new BigDecimal("99999999999999999999999999.9999991");
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = new BigDecimal("111111111111111.1111111111");
        BigDecimal temp;
        //加
        temp = bigDecimal.add(bigDecimal1);
        System.out.println(temp);
        //减
        temp = bigDecimal.subtract(bigDecimal1);
        System.out.println(temp);
        //乘
        temp = bigDecimal.multiply(bigDecimal1);
        System.out.println(temp);
        //除 除不尽会抛异常，需要制定精度
        temp = bigDecimal.divide(bigDecimal1, BigDecimal.ROUND_CEILING);//保留分子精度
        System.out.println(temp);
    }
}
