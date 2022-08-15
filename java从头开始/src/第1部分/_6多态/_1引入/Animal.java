package 第1部分._6多态._1引入;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 17:11
 * @Description 第1部分._6多态._1引入
 * @Version 1.0
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
}
class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }
}
