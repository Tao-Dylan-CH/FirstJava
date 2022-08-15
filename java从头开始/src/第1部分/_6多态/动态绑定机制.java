package 第1部分._6多态;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 17:09
 * @Description 第1部分._6多态._1引入
 * @Version 1.0
 */
public class 动态绑定机制 {
    /*
    动态绑定机制例子
    1. 当调用对象方法的时候，该方法会和对象的内存地址（运行类型）绑定
    2. 当调用对象属性时，没有动态定机制。哪里声明，哪里使用
     */
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());    //20+10：a的运行类型为B,getI()调的是子类
        System.out.println(a.sum1());   //10+10：属性没有动态绑定机制，i就是A的i
    }
}
class A{
    public int i = 10;
    public int sum(){
        return getI()+10;
    }
    public int sum1(){
        return i+10;
    }

    public int getI(){
        return i;
    }
}
class B extends A{
    public int i = 20;
//    public int sum(){
//        return getI()+10;
//    }

//    public int sum1(){
//        return i + 10;
//    }
    public int getI(){
        return i;
    }
}
