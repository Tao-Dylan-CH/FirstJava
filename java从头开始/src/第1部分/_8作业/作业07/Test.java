package 第1部分._8作业.作业07;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 23:14
 * @Description 第1部分._8作业.作业7
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("李明", 30, "内科", 'M', 5000);
        Doctor doctor1 = new Doctor("李明", 30, "内科", 'M', 5000);
        Doctor d = doctor;
        System.out.println(doctor.equals(doctor1));
        System.out.println(d.equals(doctor));
    }
}
