package 第2部分._13泛型.作业;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 17:25
 * @Description 第2部分._13泛型.作业
 * @Version 1.0
 */
public class 作业1 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("李四", 5000,
                new MyDate("2000", "04", "11")));
        list.add(new Employee("王二", 6000,
                new MyDate("1990", "10", "1")));
        list.add(new Employee("王二", 10000,
                new MyDate("1900", "03", "29")));
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if(!(o1 != null && o2 != null)){
                    return 0;
                }
//                //比名字
//                int i = o1.getName().compareTo(o2.getName());
//                if (i != 0) {
//                    return i;
//                }
//                //比年
//                i = o1.getBirthday().getYear().compareTo(o2.getBirthday().getYear());
//                if(i != 0){
//                    return i;
//                }
//                //比月
//                i = o1.getBirthday().getMonth().compareTo(o2.getBirthday().getMonth());
//                if(i != 0){
//                    return i;
//                }
//                //比日
//                i = o1.getBirthday().getDay().compareTo(o2.getBirthday().getDay());
//                return i;
                //年份的比较放在MyDate类里
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println(list);
    }
}
class Employee{
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}
class MyDate implements Comparable<MyDate>{
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
    public int compareTo(MyDate o) {
        String s1 = year + month + day;
        String s2 = o.year + o.month + o.day;
        return s1.compareTo(s2);
    }
}
