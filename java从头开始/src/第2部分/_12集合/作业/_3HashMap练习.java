package 第2部分._12集合.作业;

import java.util.*;

/**
 * @author 挚爱之夕
 * @date 2021/11/23 - 11 - 23 - 22:42
 * @Description 第2部分._12集合.作业
 * @Version 1.0
 */
public class _3HashMap练习 {
    public static void main(String[] args) {
        /*
        显示工资大于18000的员工
         */
        Map<String, Employee1> employees = new HashMap<>();
        employees.put("111", new Employee1("张三", 18000, "111"));
        employees.put("112", new Employee1("李四", 19000, "112"));
        employees.put("113", new Employee1("王二", 20000, "113"));
        //遍历方式1
        Collection<Employee1> set = employees.values();
        for (Employee1 employee:set){
            if(employee.getSalary()>18000){
                System.out.println(employee);
            }
        }
        System.out.println("----------------------------");
        //遍历方式2
        Set<String> strings = employees.keySet();
        for (String id:strings
             ) {
            Employee1 employee = employees.get(id);
            if(employee.getSalary()>18000){
                System.out.println(employee);
            }
        }
        System.out.println("----------------------------");

        //遍历方式3
        Set<Map.Entry<String, Employee1>> entries = employees.entrySet();
        for (Map.Entry<String, Employee1> entry:entries
             ) {
            Employee1 employee = entry.getValue();
            if(employee.getSalary()>18000){
                System.out.println(employee);
            }
        }
        System.out.println("----------------------------");
        //遍历方式4
        Iterator<Map.Entry<String, Employee1>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Employee1> entry = iterator.next();
            Employee1 employee = entry.getValue();
            if(employee.getSalary()>18000){
                System.out.println(employee);
            }
        }
    }
}
class Employee1{
    private String name;
    private double salary;
    private String id;

    public Employee1(String name, double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}
