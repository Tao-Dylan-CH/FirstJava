package 第2部分._10常用包装类;

/**
 * @author 挚爱之夕
 * @date 2021/11/15 - 11 - 15 - 22:03
 * @Description 第2部分.常用包装类
 * @Version 1.0
 */
public class _4String特性 {
    public static void main(String[] args) {
        Test test = new Test();
        test.change(test.str,test.ch);
        System.out.println(test.str);
        System.out.println(test.ch);
    }
}
class Test{
    String str = new String("java");
    final char[] ch = {'j','a','v','a'};
    public void change(String a, char[] b){
        a = "good"; //修改参数的地址，不影响原地址
        b[0] = 'H'; //修改内容
    }
}
