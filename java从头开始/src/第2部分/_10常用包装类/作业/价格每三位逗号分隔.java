package 第2部分._10常用包装类.作业;

/**
 * @author 挚爱之夕
 * @date 2021/11/16 - 11 - 16 - 22:19
 * @Description 第2部分.常用包装类.作业
 * @Version 1.0
 */
public class 价格每三位逗号分隔 {
    public static void main(String[] args) {
        //double超过六位会用科学计算法表示
        String price = "12345678.9";
        StringBuffer str = new StringBuffer(price);
        for (int i = str.lastIndexOf(".") - 3; i > 0; i-=3) {
            str.insert(i,",");
        }
        System.out.println(str);
    }
}
