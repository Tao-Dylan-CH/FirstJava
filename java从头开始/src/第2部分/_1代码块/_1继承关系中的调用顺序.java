package 第2部分._1代码块;

/**
 * @author 挚爱之夕
 * @date 2021/11/11 - 11 - 11 - 22:05
 * @Description 第2部分._1代码块
 * @Version 1.0
 */
public class _1继承关系中的调用顺序 {
    public static void main(String[] args) {
        new Derived();  //1.这里开始，创建前需要加载类，加载子类前要先加载父类
    }
}
class Base{
    //2.静态属性和方法的加载优先级相同，先声明先调用
    static int base = getBase();    //3.跳到getBase()初始化base
    static {
        System.out.println("2");    //5.这里打印了2
    }
    {
        System.out.println("5");    //12.这里打印了5
    }
    static int getBase() {
        System.out.println("1");    //4.这里打印了1
        return 100;
    }

    public Base() {
        //默认super()     //10.父类是Object
        //普通代码块和普通属性    //11.普通代码块和普通属性
        System.out.println("6");    //13.这里打印了6
    }
}
class Derived extends Base{
    static{                     //6.这里打印了3
        System.out.println("3");
    }
    static int derived = getDerived();  //7.跳到getDerived()初始化derived
    {
        System.out.println("7");        //15.这里打印了7
    }
    private static int getDerived() {
        System.out.println("4");        //8.这里打印了4
        return 200;
    }

    public Derived() {
        //默认super()             //9.创建Derived对象，调父类构造方法
        //普通代码块和普通属性        //14.普通代码块和普通属性
        System.out.println("8");    //16.这里打印了8
    }
}

