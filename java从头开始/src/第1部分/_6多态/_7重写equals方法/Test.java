package 第1部分._6多态._7重写equals方法;

/**
 * @author 挚爱之夕
 * @date 2021/11/7 - 11 - 07 - 9:56
 * @Description 第1部分._6多态._7重写equals方法
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("李白",18,'M');
        Person p2 = new Person("孙悟空",1000,'M');
        Person p3 = new Person("孙悟空",1000,'M');
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        String s1 = "123";
        String s2 = "123";
        String s3 = new String("123");
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }
}
