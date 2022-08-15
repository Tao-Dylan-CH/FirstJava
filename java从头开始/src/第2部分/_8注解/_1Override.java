package 第2部分._8注解;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 21:41
 * @Description 第2部分._8注解
 * @Version 1.0
 */
public class _1Override {
}
class BigBird{
    public void fly(){
        System.out.println("BigBird fly...");
    }
}
class LittleBird extends BigBird{
    //注解：重写，编译器检查该方法是否真的重写了父类的方法，如果没有构成重写，则报错
    @Override
    public void fly() {
        super.fly();
    }
}
