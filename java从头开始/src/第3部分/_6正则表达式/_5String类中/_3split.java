package 第3部分._6正则表达式._5String类中;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 11:58
 * @Description 以 - # 数字 分割字符串
 * @Version 1.0
 */
public class _3split {
    public static void main(String[] args) {
        String s = "hello-tiger#GUI78Java8";
        String[] strings = s.split("-|#|\\d+");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
