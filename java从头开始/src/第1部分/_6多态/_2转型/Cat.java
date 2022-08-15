package 第1部分._6多态._2转型;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 19:23
 * @Description 第1部分._6多态._2转型
 * @Version 1.0
 */
public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
    }
    //子类特有
    public void catchMouse(){
        System.out.println("抓到了一只老鼠...");
    }

    @Override
    public void run() {
        System.out.println("走猫步...");
    }

    @Override
    public void sleep() {
        System.out.println("打呼噜...");
    }

    @Override
    public void eat() {
        System.out.println("在吃一条三文鱼...");
    }
}
