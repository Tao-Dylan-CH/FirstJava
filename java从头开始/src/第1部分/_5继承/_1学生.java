package 第1部分._5继承;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 12:09
 * @Description 第1部分._5继承
 * @Version 1.0
 */
public class _1学生 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil("小明",14,99);
        Graduate graduate = new Graduate("大明",18,59);
        pupil.testing();
        pupil.showInformation();
        System.out.println("-----------------------");
        graduate.testing();
        graduate.showInformation();
    }
}
class Student{
    protected String name;
    protected int age;
    protected double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public void testing(){
        System.out.println(name+"正在考试...");
    }
    public void showInformation(){
        System.out.println("考完了...");
        System.out.println("成绩单：");
        System.out.println("name: "+name+" age: "+age+" score: "+score);
    }
}
class Pupil extends Student{
    public Pupil(String name,int age,double score) {
        super(name,age,score);
    }

    @Override
    public void testing() {
        System.out.print("小学生 ");
        super.testing();
    }

    @Override
    public void showInformation() {
        super.showInformation();
    }
}
class Graduate extends Student{
    public Graduate(String name, int age, double score) {
        super(name, age, score);
    }

    @Override
    public void testing() {
        System.out.print("大学生 ");
        super.testing();
    }

    @Override
    public void showInformation() {
        super.showInformation();
    }
}
