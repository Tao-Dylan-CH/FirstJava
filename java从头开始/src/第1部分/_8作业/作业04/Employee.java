package 第1部分._8作业.作业04;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:18
 * @Description 第1部分._8作业.作业4
 * @Version 1.0
 */
public class Employee {
    private String name;
    private double salary_day;
    private int work_day;
    private double grade;

    public Employee(String name, double salary_day, int work_day, double grade) {
        this.name = name;
        this.salary_day = salary_day;
        this.work_day = work_day;
        this.grade = grade;
    }

    public void printSalary(){
        System.out.println("name: "+name+" salary: "+salary_day*work_day*grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary_day() {
        return salary_day;
    }

    public void setSalary_day(double salary_day) {
        this.salary_day = salary_day;
    }

    public int getWork_day() {
        return work_day;
    }

    public void setWork_day(int work_day) {
        this.work_day = work_day;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
