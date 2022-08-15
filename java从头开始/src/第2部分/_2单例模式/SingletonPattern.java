package 第2部分._2单例模式;

/**
 * @author 挚爱之夕
 * @date 2021/11/11 - 11 - 11 - 22:46
 * @Description 第2部分._2单例模式
 * @Version 1.0
 */
public class SingletonPattern {
    public static void main(String[] args) {
        GirlFriend girlFriend1 = GirlFriend.getInstance();
        System.out.println(girlFriend1);
        Cat cat = Cat.getInstance();
        System.out.println(cat);
    }
}
//饿汉式
class GirlFriend{
    private String name;
    //1.构造器私有化
    private GirlFriend(String name){
        this.name = name;
    }
    //2.内部创建唯一对象
    private static GirlFriend girlFriend = new GirlFriend("小白");

    //3.通过公共的静态方法，向外部提供唯一实例
    public static GirlFriend getInstance(){
        return girlFriend;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
//懒汉式
class Cat{
    private String name;

    private static Cat cat;
    private Cat(String name) {
        this.name = name;
    }
    //需要时，才创建，只创建一次
    public static Cat getInstance(){
        if(cat == null){
            cat = new Cat("小黑");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}