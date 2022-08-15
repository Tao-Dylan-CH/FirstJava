package 第1部分._8作业.作业05;



/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:43
 * @Description 第1部分._8作业.作业5
 * @Version 1.0
 */
public class Worker extends Employee {
    public Worker(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public String toString() {
        return "worker: \n" + super.toString();
    }

    @Override
    public void printTotalSalary() {
        super.printTotalSalary();
    }
}
