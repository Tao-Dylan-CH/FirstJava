package 第1部分._7断点调试;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 12:27
 * @Description 第1部分._7断点调试
 * @Version 1.0
 */
public class _4Debug {
    /*
    追踪对象创建过程,加深对调试的理解
     */
    public static void main(String[] args) {
        Person person = new Student("李白",18,111001);
        System.out.println(person);
    }
}
class Person{
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Student extends Person{
    private int id;

    public Student(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
