package 第1部分._8作业.作业05;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:57
 * @Description 第1部分._8作业.作业5
 * @Version 1.0
 */
public class Scientist extends Employee {
    private double yearEndBonus;

    public Scientist(String name, double baseSalary, double yearEndBonus) {
        super(name, baseSalary);
        this.yearEndBonus = yearEndBonus;
    }

    @Override
    public String toString() {
        return "Scientist:\n" + super.toString() +
                " yearEndBonus: " + yearEndBonus +
                " yearEndBonus: " + yearEndBonus;
    }

    @Override
    public void printTotalSalary() {
        System.out.print("科学家：");
        System.out.println("年薪为：" + (getBaseSalary() * getWork_month() + yearEndBonus));
    }

    public double getYearEndBonus() {
        return yearEndBonus;
    }

    public void setYearEndBonus(double yearEndBonus) {
        this.yearEndBonus = yearEndBonus;
    }
}
