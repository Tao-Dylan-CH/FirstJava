package 第1部分._8作业.作业09;

/**
 * @author 挚爱之夕
 * @date 2021/11/9 - 11 - 09 - 21:18
 * @Description 第1部分._8作业.作业09
 * @Version 1.0
 */
public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, int age, String sex, int work_age) {
        super(name, age, sex);
        this.work_age = work_age;
    }


    public void printBaseInformation(){
        System.out.println("老师信息：");
        System.out.println(super.getBaseInformation());
        System.out.println("工龄：" + work_age);
        teach();
        System.out.println(play());
    }

    public void teach(){
        System.out.println("我承诺，我会好好授课。");
    }

    @Override
    public String play() {
        return  super.play() +"象棋。";
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
}
