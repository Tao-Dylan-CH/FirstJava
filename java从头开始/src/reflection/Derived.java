package reflection;

/**
 * @author 挚爱之夕
 * @date 2021-12-18 - 12 - 18 - 21:56
 * @Description reflection
 * @Version 1.0
 */
@Deprecated
public class Derived extends Base implements IA, IB{
    //属性
    public String name;
    protected int age;
    String sex;
    private double salary;
    public Derived(){

    }
    private Derived(String name){

    }
    //方法
    public void m1(String name, int age){

    }
    protected void m2(){

    }
    void m3(){

    }
    private void m4(){

    }
}
