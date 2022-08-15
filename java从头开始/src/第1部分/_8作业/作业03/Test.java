package 第1部分._8作业.作业03;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 23:42
 * @Description 第1部分._8作业.作业3
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("李米",38,"老师",5000);
        Professor snap = new Professor("snap", 28, "Professor", 8000);
        teacher.introduce();
        snap.introduce();
    }
}
