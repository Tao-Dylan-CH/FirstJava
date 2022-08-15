package 第2部分._13泛型._1自定义泛型;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 22:25
 * @Description 第2部分._13泛型._1自定义泛型
 * @Version 1.0
 */
public class _1自定义泛型类 {
    public static void main(String[] args) {
        Animal<String, Integer> cat = new Animal<>("大白", 1);

    }
    static class  Animal<T, R>{
        T name;
        R age;
//        static  T t;  静态不能用泛型
//        T[]  names  = new Object[]; 不能初始化
        public Animal(T name, R age) {
            this.name = name;
            this.age = age;
        }
    }
}
