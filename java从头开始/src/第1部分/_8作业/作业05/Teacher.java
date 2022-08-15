package 第1部分._8作业.作业05;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:46
 * @Description 第1部分._8作业.作业5
 * @Version 1.0
 */
public class Teacher extends Employee{
    private double dailyWage;
    private int work_day;

    public Teacher(String name, double baseSalary, double dailyWage) {
        super(name, baseSalary);
        this.dailyWage = dailyWage;
    }

    @Override
    public String toString() {
        return "Teacher:\n"+super.toString()+" dailyWage: "+dailyWage + " work_day: " + work_day;
    }

    @Override
    public void printTotalSalary() {
        System.out.println("年薪为：" + (getBaseSalary()* getWork_month() + dailyWage * work_day));
    }

    public double getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(double dailyWage) {
        this.dailyWage = dailyWage;
    }

    public int getWork_day() {
        return work_day;
    }

    public void setWork_day(int work_day) {
        this.work_day = work_day;
    }
}
