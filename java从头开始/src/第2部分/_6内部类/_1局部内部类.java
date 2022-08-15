package 第2部分._6内部类;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 19:50
 * @Description 第2部分._6内部类
 * @Version 1.0
 */
public class _1局部内部类 {
    public static void main(String[] args) {
        new Out().m();
    }
}
//局部内部类演示
class Out{
    private int n = 1;
    private void m1(){
        System.out.println("Out m1()");
    }
    public void m(){
        //局部内部类，本质是类，局部变量，只能用final修饰
        class Inner{
            private int n = 2;
            //局部内部类可以访问外部类的所有成员
            public void f(){
                //1. 如果外部类和局部内部类的成员重名时，默认遵循就近原则。
                // 如果想访问外部类的成员，则可以使用（外部类名.this.成员）去访回
                System.out.println("n = " + n + "外部n = " + Out.this.n);
                m1();
            }
        }
        Inner inner = new Inner();
        inner.f();
    }
}
