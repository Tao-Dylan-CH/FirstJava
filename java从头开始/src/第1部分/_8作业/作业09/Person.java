package 第1部分._8作业.作业09;

/**
 * @author 挚爱之夕
 * @date 2021/11/9 - 11 - 09 - 21:16
 * @Description 第1部分._8作业.作业09
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;
    private String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String play(){
        return name+"爱玩";
    }

    public String getBaseInformation(){
        return "name : " + name + "\nage: " + age + "\nsex: " + sex;
    }

    public void printBaseInformation(){
        System.out.println("person:");
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
