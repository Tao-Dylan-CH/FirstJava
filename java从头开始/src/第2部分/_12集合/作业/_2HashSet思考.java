package 第2部分._12集合.作业;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author 挚爱之夕
 * @date 2021/11/22 - 11 - 22 - 21:56
 * @Description 第2部分._12集合.作业
 * @Version 1.0
 */
public class _2HashSet思考 {
    public static void main(String[] args) {
        Set<Employee> set = new HashSet<>();
        set.add(new Employee("张三", 120, new MyDate("2000", "03", "09")));
        set.add(new Employee("张三", 100, new MyDate("2000", "03", "10")));
        System.out.println(set);
    }
}
class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.name.equals(employee.name)&& this.birthday.equals(employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
class MyDate{
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return this.year.equals(myDate.year)&&this.month.equals(myDate.month)&&this.day.equals(myDate.day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}