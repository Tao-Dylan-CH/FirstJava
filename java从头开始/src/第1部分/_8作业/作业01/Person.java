package 第1部分._8作业.作业01;


/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 23:24
 * @Description 第1部分._8作业.作业1
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return name + "\t" + age + "\t" + job;
    }
}
class Test{
    public static void main(String[] args) {
        Person[] peoples = new Person[3];
        peoples[0] = new Person("李白",18,"剑客");
        peoples[1] = new Person("悟空",100,"斗战胜佛");
        peoples[2] = new Person("Ron",17,"wizard");
        for (int i = 0; i < peoples.length - 1; i++) {
            for (int j = 0; j < peoples.length - 1 - i; j++) {
                if(peoples[i].getAge()<peoples[i+1].getAge()){
                    Person temp = peoples[i];
                    peoples[i] = peoples[i+1];
                    peoples[i+1] = temp;
                }
            }
        }
        System.out.println("姓名\t年龄\t工作");
        for (int i = 0; i < peoples.length; i++) {
            System.out.println(peoples[i]);
        }
    }
}
