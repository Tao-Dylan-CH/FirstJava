package 第2部分._6内部类;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 13:22
 * @Description 第2部分._6内部类
 * @Version 1.0
 */
public class _5静态内部类 {
    public static void main(String[] args) {
        new Outer2().print();
        //外部其他类，访问静态内部类
        //第1种方式：通过创建静态内部类直接访问（要有访问权限）
        new Outer2.Inner2().say();
        //第2种方式：外部类中编写方法，返回静态内部类实例
        new Outer2().getInnerObject();

    }
}
class Outer2{
    static int n = 100;
    String s = "访问不到";
    static class Inner2{
        int n = 200;
        public void say(){
            //访问外部类静态成员
            System.out.println("内部：n = "+ n + " 外部 ： n = "+Outer2.n);
//            System.out.println(s);  //不能访问非静态的
        }
    }
    public void print(){
        //访问静态内部类
        new Inner2().say();
    }
    public Inner2 getInnerObject(){
        return new Inner2();
    }
}