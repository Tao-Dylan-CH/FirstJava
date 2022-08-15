package 第1部分._8作业.作业09;

/**
 * @author 挚爱之夕
 * @date 2021/11/9 - 11 - 09 - 21:17
 * @Description 第1部分._8作业.作业09
 * @Version 1.0
 */
public class Student extends Person{
    private String id;

    public Student(String name, int age, String sex, String id) {
        super(name, age, sex);
        this.id = id;
    }

    public void printBaseInformation(){
        System.out.println("学生信息：");
        System.out.println(super.getBaseInformation());
        System.out.println("学号：" + id);
        study();
        System.out.println(play());
    }

    @Override
    public String play() {
        return super.play()+"足球。";
    }

    public void study(){
        System.out.println("我承诺，我会好好学习。");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
