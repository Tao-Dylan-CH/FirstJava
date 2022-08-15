package 第2部分._11常用类._2大数据;

import java.math.BigInteger;

/**
 * @author 挚爱之夕
 * @date 2021/11/17 - 11 - 17 - 11:13
 * @Description 第2部分._11常用类._2大数据
 * @Version 1.0
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
//        long l = 88888888884999999999999;
//        System.out.println(l);
        //数据太大，long存不下
        BigInteger bigInteger = new BigInteger("88888888884999999999999");
        BigInteger bigInteger1 = new BigInteger("11111111111111111111");
        BigInteger temp;
        System.out.println(bigInteger);
        //加 返回一个BigInteger
        temp = bigInteger.add(bigInteger1);
        System.out.println(temp);
        //减
        temp = bigInteger.subtract(bigInteger1);
        System.out.println(temp);
        //乘
        temp = bigInteger.multiply(bigInteger1);
        System.out.println(temp);
        //除
        temp = bigInteger.divide(bigInteger1);
        System.out.println(temp);
    }
}
