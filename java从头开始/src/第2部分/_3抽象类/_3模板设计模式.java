package 第2部分._3抽象类;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 16:20
 * @Description 第2部分._3抽象类
 * @Version 1.0
 */
public class _3模板设计模式 {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.calculateTime();
        Manager1 manager1 = new Manager1();
        manager1.calculateTime();
    }
}
abstract class Template{
    public abstract void job();
    public void calculateTime(){
        //除了job()外都为公用代码，提取处理，提高代码复用性
        //不同计算用时的方法，只需重写job()即可
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("用时： " + (end - start) + "ms");
    }
}
class Worker extends Template{
    @Override
    public void job() {
        long num = 0;
        for (int i = 0; i < 1000000; i++) {
            num += i;
        }
    }
}
class Manager1 extends Template{
    @Override
    public void job() {
        long num = 1;
        for (int i = 1; i < 1000000; i++) {
            num *= i;
        }
    }
}