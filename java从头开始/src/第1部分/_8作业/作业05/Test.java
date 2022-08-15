package 第1部分._8作业.作业05;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 9:00
 * @Description 第1部分._8作业.作业5
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Employee employee;
        employee= new Peasant("农民", 3000);
        System.out.println(employee.toString());
        employee.printTotalSalary();
        System.out.println("========================");
        employee = new Worker("工人", 5000);
        System.out.println(employee.toString());
        employee.printTotalSalary();
        System.out.println("========================");
        employee = new Teacher("老师",6000,100);
        //设置上课天数
        ((Teacher)employee).setWork_day(100);
        System.out.println(employee.toString());
        employee.printTotalSalary();
        System.out.println("========================");
        employee = new Scientist("科学家",10000, 20000);
        System.out.println(employee.toString());
        employee.printTotalSalary();
    }
}
