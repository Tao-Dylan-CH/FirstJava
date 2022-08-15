package 第1部分._8作业.作业04;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:21
 * @Description 第1部分._8作业.作业4
 * @Version 1.0
 */
public class Manager extends Employee{
    private double bonus;
    //创建经理，奖金不定，构造不给奖金，通过set赋值
    public Manager(String name, double salary_day, int work_day) {
        super(name, salary_day, work_day,1.3);
    }

    @Override
    public void printSalary() {
        System.out.println("name: "+getName()+" salary: "+(getSalary_day()*getWork_day()*getGrade()+bonus));
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
