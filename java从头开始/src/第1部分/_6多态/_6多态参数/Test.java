package 第1部分._6多态._6多态参数;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 21:49
 * @Description 第1部分._6多态._6多态参数
 * @Version 1.0
 */
public class Test {
    /*多态参数*/
    public static double getEmployeeAnnual(Employee e){
        return e.getAnnual();
    }
    public static void testWork(Employee e){
        if(e instanceof Manager){
            ((Manager) e).manage();
        }else if(e instanceof Stuff){
            Stuff stuff = (Stuff)e;
            stuff.work();
        }else{
            System.out.println("不是普通员工或经理");
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager("孙悟空", 5000, 5000);
        Stuff stuff = new Stuff("李白", 4000);
        testWork(manager);
        testWork(stuff);
        System.out.println(getEmployeeAnnual(manager));
        System.out.println(getEmployeeAnnual(stuff));
    }
}
