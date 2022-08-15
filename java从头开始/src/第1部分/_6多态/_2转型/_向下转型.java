package 第1部分._6多态._2转型;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 19:32
 * @Description 第1部分._6多态._2转型
 * @Version 1.0
 */
public class _向下转型 {
    public static void main(String[] args) {
        /*
        向下转型
        将父类引用强转为子类引用
        要求父类的引用必须指向的是当前目标类型的对象
         */
        Animal animal = new Cat("大黑",6);
        Animal animal1 = new Animal("动物",1);
        Cat cat = (Cat) animal;
        //转型后可以访问子类特有的成员
        cat.catchMouse();
//        cat = (Cat) animal1;  //ClassCastException,不能将 Animal 转为 Cat
//        cat.catchMouse();
        Dog dog = (Dog) animal;    //ClassCastException，不能将Cat 转为 Dog
    }
}
