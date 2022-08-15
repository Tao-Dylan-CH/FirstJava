package 第1部分._4封装;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 11:06
 * @Description 第1部分._4封装
 * @Version 1.0
 */
public class _1员工信息管理 {
    public static void main(String[] args) {
        Staff staff = new Staff();
        Staff jack = new Staff("jack", 19, 10000);
        System.out.println(jack.toString());
        System.out.println(staff.toString());
    }


}

class Staff {
    public String name;
    private int age;
    private double salary;

    public Staff() {

    }

    public Staff(String name, int age, double salary) {
        setName(name);
        setAge(age);
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            this.name = null;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 120) {
            this.age = age;
        } else {
            System.out.println("输入年龄不在（1-120）,已经默认设为18.");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //输出信息
    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
