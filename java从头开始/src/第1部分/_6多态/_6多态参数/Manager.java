package 第1部分._6多态._6多态参数;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 21:47
 * @Description 第1部分._6多态._6多态参数
 * @Version 1.0
 */
public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println(getName() + " 正在管理...");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual()+bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
