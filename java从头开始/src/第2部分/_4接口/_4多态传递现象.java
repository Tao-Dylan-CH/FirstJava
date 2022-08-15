package 第2部分._4接口;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 18:11
 * @Description 第2部分._4接口
 * @Version 1.0
 */
public class _4多态传递现象 {
    public static void main(String[] args) {
        Interface2 interface2 = new Demo();
        Interface1 interface1 = new Demo(); //Demo类没有实现Interface1接口
    }
}
interface Interface1{

}
//Interface2继承Interface1，则Demo间接实现（如果Interface1里有抽象方法，则需要实现）Interface1
interface Interface2 extends Interface1{

}
class Demo implements Interface2{

}
