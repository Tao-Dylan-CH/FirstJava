package 第1部分._8作业.作业04;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 8:24
 * @Description 第1部分._8作业.作业4
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Employee employee;
        employee = new Worker("赵四",100,200,1.0);
        employee.printSalary();
        employee = new Manager("李华",200,200);
        //设置奖金
        ((Manager) employee).setBonus(2000);
        employee.printSalary();
    }
}
