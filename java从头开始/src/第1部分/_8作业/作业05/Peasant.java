package 第1部分._8作业.作业05;



/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:45
 * @Description 第1部分._8作业.作业5
 * @Version 1.0
 */
public class Peasant extends Employee {
    public Peasant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public String toString() {
        return "Peasant: \n"+super.toString();
    }

    @Override
    public void printTotalSalary() {
        super.printTotalSalary();
    }
}
