package 第2部分._15IO流._4对象流;

import java.io.*;

/**
 * @author 挚爱之夕
 * @date 2021/12/4 - 12 - 04 - 21:54
 * @Description 第2部分._15IO流._4对象流
 * @Version 1.0
 */
public class _1ObjectInputStream {
    /*
    演示ObjectInputStream的使用，完成数据的序列化
     */
    public static void main(String[] args) throws IOException {
        ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("D:/ObjectInput.data"));
        out.writeInt(10);  //10 -> Integer (Integer实现了序列化接口)
        out.writeChar('O');// -> Character
        out.writeBoolean(true); // -> Boolean
        out.writeDouble(1.11);  // - >Double
        out.writeUTF("JAVA");
        out.writeObject(new Person("孙悟空", 1000));
        out.close();
        System.out.println("序列化写入成功！");
    }
}
//当一个类的对象需要序列化，该类需要实现Serializable或Externalizable接口
class Person implements Serializable {
    /*
    serialVersionUID 序列化版本号，提高兼容性
    比如当前类添加了新的属性，添加了序列号，会认为是版本更新，而不会认为是一个新的类
     */
    private static final long serialVersionUID = 10;
    private String name;
    private int age;
    //因为加入了序列化版本号，写入后加入新属性，再反序列化读入，并不会报错
    int salary;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    /*
    static、transient 修饰的不会被序列化
     */
    static String color;
    transient long numberOfHair;
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}