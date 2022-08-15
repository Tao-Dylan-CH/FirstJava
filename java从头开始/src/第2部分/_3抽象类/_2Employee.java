package 第2部分._3抽象类;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 16:01
 * @Description 第2部分._3抽象类
 * @Version 1.0
 */
public class _2Employee {
    public static void main(String[] args) {
        CommonEmployee commonEmployee = new CommonEmployee("李四", "11029", 3000);
        Manager manager = new Manager("张三", "110", 5000, 2000);
        commonEmployee.work();
        manager.work();
    }
}
abstract class Employee{
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}
class CommonEmployee extends Employee{
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }
    @Override
    public void work() {
        System.out.println("普通员工 " + getName() + " 工作中...");
    }
}
class Manager extends Employee{
    private double bonus;

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理 " + getName() + " 工作中...");
    }
}