package 第2部分._6内部类;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 13:04
 * @Description 第2部分._6内部类
 * @Version 1.0
 */
public class _4成员内部类 {
    public static void main(String[] args) {
        new Outer1().say();
        //其他类访问内部类
        //第1种方式:先创建外部类，再创建内部类
        Outer1.Inner1 inner1 = new Outer1().new Inner1();
        //第2种方式:外部类编写一个方法，向外界提供一个内部类对象
        Outer1.Inner1 inner2 = new Outer1().getInnerObject();

    }
}
class Outer1{
    private int n = 10;
    class Inner1{
        public int n = 20;
        public void print(){
            //访问外部类成员
            System.out.println("内部：n = "+ n + "外部 ： n = "+Outer1.this.n);
        }
    }
    //访问内部类
    public void say(){
        //创建内部类对象
        Inner1 inner1 = new Inner1();
        inner1.print();
    }
    //向外界提供一个内部类对象
    public Inner1 getInnerObject(){
        return new Inner1();
    }
}