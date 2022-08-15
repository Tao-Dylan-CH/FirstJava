package 第1部分._6多态._3关于属性问题;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 19:59
 * @Description 第1部分._6多态._关于属性问题
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        /*
        属性没有重写之说
        属性的值直接看编译类型
        base引用的编译类型是Base,运行类型是Derived
        derived引用的编译类型是Derived,运行类型是Derived
         */
        Base base = new Derived();
        System.out.println(base.count); //打印父类的10
        Derived derived = new Derived();
        System.out.println(derived.count);  //打印子类20
    }
}
