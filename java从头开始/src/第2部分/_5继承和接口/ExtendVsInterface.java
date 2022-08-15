package 第2部分._5继承和接口;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 17:32
 * @Description 第2部分._5继承和接口
 * @Version 1.0
 */
public class ExtendVsInterface {
    public static void main(String[] args) {
        FantasticMonkey sunWuKong = new FantasticMonkey("孙悟空");
        sunWuKong.climb();
        sunWuKong.fly();
    }
}
class Monkey{
    private String name;

    public Monkey(String name) {
        this.name = name;
    }
    public void climb(){
        System.out.println(name + " 会爬树");
    }

    public String getName() {
        return name;
    }
}
//继承
class FantasticMonkey extends Monkey implements flyable{
    public FantasticMonkey(String name) {
        super(name);
    }

    @Override
    public void climb() {
        super.climb();
    }

    @Override
    public void fly() {
        System.out.println("通过学习\n" + getName() + " 一个筋斗十万八千里...");
    }
}
//接口
interface flyable{
    void fly();
}