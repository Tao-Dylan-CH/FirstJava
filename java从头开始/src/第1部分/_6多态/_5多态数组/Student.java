package 第1部分._6多态._5多态数组;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 20:48
 * @Description 第1部分._6多态._5多态数组
 * @Version 1.0
 */
public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String say() {
        return super.say()+",score = "+score;
    }

    public void study(){
        System.out.println(getName()+" is learning java...");
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
