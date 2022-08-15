package 第1部分._6多态._1引入;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 17:18
 * @Description 第1部分._6多态._1引入
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Master master = new Master("汤姆");

        Dog dog = new Dog("大黄");
        Bone bone = new Bone("牛骨头");

        Cat cat = new Cat("小白");
        Fish fish = new Fish("黄花鱼");

        master.feed(dog, bone);
        master.feed(cat, fish);
    }
}
