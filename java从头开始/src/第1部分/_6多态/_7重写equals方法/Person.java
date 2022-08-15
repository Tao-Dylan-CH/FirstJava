package 第1部分._6多态._7重写equals方法;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 9:45
 * @Description 第1部分._6多态._7重写equals方法
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        return false;
    }
}