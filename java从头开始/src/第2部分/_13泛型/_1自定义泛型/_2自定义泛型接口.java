package 第2部分._13泛型._1自定义泛型;

/**
 * @author 挚爱之夕
 * @date 2021/11/24 - 11 - 24 - 22:31
 * @Description 第2部分._13泛型._1自定义泛型
 * @Version 1.0
 */
public class _2自定义泛型接口 {
    public static void main(String[] args) {
        U u = new U();
        String ui = u.getT("ui");
        System.out.println(ui);
    }
    interface UI<T, R>{
//        T n;  //接口中属性是静态的，不能用泛型
        T getT(T t);

    }
    static class U implements UI<String, Integer>{

        @Override
        public String getT(String s) {
            return s;
        }
    }
}
