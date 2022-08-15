package 第1部分._8作业.作业03;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 23:36
 * @Description 第1部分._8作业.作业3
 * @Version 1.0
 */
public class Teacher {
    protected String name;
    protected int age;
    protected String post;
    protected double salary;

    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("name=" + name + ",age=" + age + ",post" + post + ",salary=" + salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Professor extends Teacher {
    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.3);
    }
}

class AssociateProfessor extends Teacher {
    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.2);
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary * 1.1);
    }
}
