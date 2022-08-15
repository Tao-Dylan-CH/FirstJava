package 第1部分._6多态._2转型;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 19:21
 * @Description 第1部分._6多态._2转型
 * @Version 1.0
 */
public class Animal {
    private String name;
    private int age;
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void run(){
        System.out.println("跑");
    }
    public void sleep(){
        System.out.println("睡觉...");
    }
    public void eat(){
        System.out.println("吃东西");
    }
    public void jump(){
        System.out.println("跳");
    }
}
