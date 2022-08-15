package 第2部分._15IO流.作业;

import java.io.*;
import java.util.Properties;

/**
 * @author 挚爱之夕
 * @date 2021/12/5 - 12 - 05 - 11:28
 * @Description 第2部分._15IO流.作业
 * @Version 1.0
 */
public class 作业04 {
    /*
    读取properties配置文件
    创建dog对象
    将dog序列化写入磁盘文件
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建properties对象
        Properties properties = new Properties();
        //加载配置信息
        properties.load(new FileReader("src/dog.properties"));
        String name = properties.get("name").toString();
        int age = Integer.parseInt(properties.get("age")+"");
        String color = properties.get("color") + "";
        //创建dog对象
        Dog dog = new Dog(name, age, color);
        System.out.println("---dog信息---");
        System.out.println(dog);
        //序列化写入磁盘文件
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:/dog.data"));
        out.writeObject(dog);
        System.out.println("dog序列化成功！");
        out.close();
        //反序列化读取
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:/dog.data"));
        Object o = in.readObject();
        System.out.println(o);
        System.out.println("dog信息反序列化成功！");
        Dog dog1 = (Dog)o;
        in.close();
        dog1.move();
    }
    private static class Dog implements Serializable {
        String name;
        int age;
        String color;
        private final static long SerialVersionUID = 123;
        public Dog(String name, int age, String color) {
            this.name = name;
            this.age = age;
            this.color = color;
        }
        public void move(){
            System.out.println("刚创建的狗撒腿就跑...");
        }
        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
