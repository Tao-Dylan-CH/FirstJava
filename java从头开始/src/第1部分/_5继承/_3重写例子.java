package 第1部分._5继承;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 16:51
 * @Description 第1部分._5继承
 * @Version 1.0
 */
public class _3重写例子 {
    public static void main(String[] args) {
        Person person = new Person("Harry Potter",18);
        Student1 student = new Student1("Hermione Granger",18,"101",100);
        System.out.println(person.say());
        System.out.println(student.say());
    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String say(){
        return "My name is "+name+", I'm "+age+" years old.";
    }
}
class Student1 extends Person{
    private String id;
    private double score;

    public Student1(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    @Override
    public String say() {
        return super.say()+"\nAnd my id is "+id+", I got "+score+" score.";
    }
}