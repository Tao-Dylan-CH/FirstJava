package 第1部分._6多态._2转型;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 19:21
 * @Description 第1部分._6多态._2转型
 * @Version 1.0
 */
public class _1向上转型 {
    public static void main(String[] args) {
        //向上转型：子类对象赋给父类的引用
        /*
        当前cat的编译类型为Animal
        运行类型为Cat
        cat只能访问父类的成员，不能访问子类特有成员：因为在编译阶段，能调用什么方法是由编译类型决定的
        调用的方法是子类重写后的效果：方法调用依然从子类开始，如果子类重写了父类的方法，则是子类方法效果，否则是父类效果
         */
        Animal animal = new Cat("小白",3);
        //Cat类重写了eat()、run()、sleep()
        animal.eat();
        animal.run();
        animal.sleep();
        //Cat类没有重写jump()
        animal.jump();
//        cat.catchMouse();   //无法调用子类特有的方法，编译出错
    }
}
