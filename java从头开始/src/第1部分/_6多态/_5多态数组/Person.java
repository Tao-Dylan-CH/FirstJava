package 第1部分._6多态._5多态数组;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 20:47
 * @Description 第1部分._6多态._5多态数组
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //say
    public String say(){
        return "name = "+name+",age = "+age;
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
