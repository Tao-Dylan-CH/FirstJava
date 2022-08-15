package 第1部分._8作业.作业05;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:40
 * @Description 第1部分._8作业.作业5
 * @Version 1.0
 */
public class Employee {
    private String name;
    private double baseSalary;
    //默认设为工作12个月
    private int work_month = 12;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "name: " + name + " baseSalary: " + baseSalary + " work_month " + work_month;
    }

    public void printTotalSalary(){
        System.out.println("年薪为："+baseSalary * work_month);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWork_month() {
        return work_month;
    }

    public void setWork_month(int work_month) {
        this.work_month = work_month;
    }
}
