package 第2部分._3抽象类;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 15:40
 * @Description 第2部分._3抽象类
 * @Version 1.0
 */
public class _1抽象类引入 {
    public static void main(String[] args) {

    }
}

abstract class Animal{
    //方法操作不确定，应为抽象方法
    public void work1(){
        System.out.println("不知道干什么...");
    }
    abstract public void work();
}
