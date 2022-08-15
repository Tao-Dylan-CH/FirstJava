package 第2部分._9异常;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 21:29
 * @Description 第2部分._9异常
 * @Version 1.0
 */
public class _3自定义异常 {
    public static void main(String[] args) {
        int age = 10;
        if(age<18||age>120)
            throw new AgeException("年龄异常。");
        System.out.println("你的年龄在正常范围。");
    }
}
/*
自定义异常
1.一般情况下继承RuntimeException
2.即是把自定义异常 做成运行时异常，可以使用java默认处理机制
 */
class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}