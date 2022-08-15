package 第2部分.作业.作业03;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 12:59
 * @Description 第2部分.作业.作业03
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        new A("Harry").show();
    }
}
class A{
    private String name;

    public void show(){
        //局部内部类
        class B{
            private String name;
            public void show(){
                System.out.println("内部：" + name + " 外部：" + A.this.name);
            }

            public B(String name) {
                this.name = name;
            }
        }
        new B("Ron").show();
    }

    public A(String name) {
        this.name = name;
    }
}
