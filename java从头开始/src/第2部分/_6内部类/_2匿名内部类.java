package 第2部分._6内部类;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 20:19
 * @Description 第2部分._6内部类
 * @Version 1.0
 */
public class _2匿名内部类 {
    public static void main(String[] args) {
        new Outer().method();
    }
}

class Outer{    //外部类
    private int n  = 10;
    public void method(){
        //基于接口的匿名内部类

        //编译类型：IA
        //运行类型：匿名类

        /*
        底层：class XXX implements IA{
            public void cry() {
                System.out.println("cry...");
            }
        }
        xxx= Outer$1
        jdk 底层在创建匿名内部类， 立马创建了实例，并把地址返回
         */
        IA ia = new IA() {
            int n = 20;
            @Override
            public void cry() {
                //Outer.this 就是调用method的对象
                System.out.println("inner n =" + n + " outer n=" + Outer.this.n);
                System.out.println("cry...");
            }
        };
        System.out.println(ia.getClass());
        ia.cry();

        /*
        编译类型：Father
        运行类型：匿名类 Outer$2
        底层：class Outer$2 extends Father{
            public void test() {
                System.out.println("重写test()方法...");
            }
        }
         */
        Father father = new Father("jack"){ //参数列表会传递给构造器
            @Override
            public void test() {
                System.out.println("重写test()方法...");
            }
        };
        System.out.println(father.getClass());
        father.test();
    }
}
interface IA{
    void cry();
}
class Father{
    public Father(String name){

    }
    public void test(){

    }
}