package 第2部分._13泛型._1自定义泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 23:10
 * @Description 第2部分._13泛型._1自定义泛型
 * @Version 1.0
 */
public class _4泛型继承和通配符 {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<A> list2 = new ArrayList<>();
        List<B> list3 = new ArrayList<>();
        List<C> list4 = new ArrayList<>();

        //任意
        printList1(list1);
        printList1(list2);
        printList1(list3);
        printList1(list4);
        //A类及其子类
//        printList2(list1);    //错误
        printList2(list2);
        printList2(list3);
        printList2(list4);
        //A类及其父类
        printList3(list1);
        printList3(list2);
//        printList3(list3);    //错误
//        printList3(list4);    //错误
    }
    //任意
    private static void printList1(List<?> list){
        for (Object c:list
             ) {
            System.out.println(c);
        }
    }
    //A类及其子类
    private static void printList2(List<? extends A> list){
        for (Object c:list
             ) {
            System.out.println(c);
        }
    }
    //A类及其父类
    private static void printList3(List<? super A> list){
        for (Object c:list
             ) {
            System.out.println(c);
        }
    }
}
class A{

}
class B extends A{

}
class C extends B{

}