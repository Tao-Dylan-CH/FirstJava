package 第1部分._6多态._5多态数组;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 20:52
 * @Description 第1部分._6多态._5多态数组
 * @Version 1.0
 */
public class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say()+",salary = "+salary;
    }

    public void teach(){
        System.out.println(getName()+" is teaching java...");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
