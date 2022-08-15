package 第2部分._13泛型._1自定义泛型;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 22:45
 * @Description 第2部分._13泛型._1自定义泛型
 * @Version 1.0
 */
public class _3自定义泛型方法 {
    public static void main(String[] args) {
        Bird<String, String> b = new Bird<>();
        b.Fly("fly...");
        Fish fish = new Fish();
        fish.swim("swimming...");
    }
    static class Bird<T,R>{
        //使用了类声明的泛型的方法
        public void Fly(T s){
            System.out.println(s);
        }
    }
    static class Fish{
        //泛型方法
        public <T> void swim(T s){
            System.out.println(s);
        }
    }
}
