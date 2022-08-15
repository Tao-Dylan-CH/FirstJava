package 第1部分._6多态._4instanceOf操作符;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 20:13
 * @Description 第1部分._6多态._4instanceOf操作符
 * @Version 1.0
 */
public class Explain {
    public static void main(String[] args) {
        Father f = new Father();
        System.out.println(f instanceof Son);

        Son son = new Son();
        System.out.println(son instanceof Son);
        System.out.println(son instanceof Father);

        Father father = new Son();
        System.out.println(father instanceof Father);
        System.out.println(father instanceof Son);

        String str = "123";
        System.out.println(str instanceof Object);
    }
}
