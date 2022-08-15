package 第1部分._6多态._6多态参数;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 21:44
 * @Description 第1部分._6多态._6多态参数
 * @Version 1.0
 */
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getAnnual(){
        return salary*12;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
