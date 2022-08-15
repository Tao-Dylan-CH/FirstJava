package 第2部分._8注解;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 21:52
 * @Description 第2部分._8注解
 * @Version 1.0
 */
public class _2Deprecated {
    public static void main(String[] args) {
        new Tool().print();
        double pi = Tool.pi;
    }
}
@Deprecated
class Tool{
    //表示该元素过时了
    @Deprecated
    static double pi = 3.14;
    @Deprecated
    public void print(){
        System.out.println("print:");
    }
}