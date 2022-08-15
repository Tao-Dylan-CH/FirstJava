package 第2部分._15IO流._4对象流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 挚爱之夕
 * @date 2021/12/4 - 12 - 04 - 22:11
 * @Description 第2部分._15IO流._4对象流
 * @Version 1.0
 */
public class _2ObjectOutputStream {
    /*
    ObjectOutputStream 演示，实现数据的反序列化
     */
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            /*
            读取的顺序(反序列化)要与写入(序列化)的顺序一致
             */
            ois = new ObjectInputStream(new FileInputStream("D:/ObjectInput.data"));
            System.out.println(ois.readInt());
            System.out.println(ois.readChar());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readDouble());
            System.out.println(ois.readUTF());
            /*
            读取一个对象该类要在当前目录可以访问到
            写入时类的信息要和现在的相同，所在包名也要相同
             */
            Object person = ois.readObject();
            /*
            person 的编译类型是 Object 运行类型是Person
            如果要使用person的方法，需要向下转型
             */
            Person p = (Person)person;
            System.out.println(p.getName() + " " + p.getAge());

            System.out.println(p.salary);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
