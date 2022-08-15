package 第1部分._6多态._6多态参数;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 21:45
 * @Description 第1部分._6多态._6多态参数
 * @Version 1.0
 */
public class Stuff extends Employee {
    public Stuff(String name, double salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println(getName()+" 正在工作...");
    }
}
