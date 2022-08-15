package 第2部分._14线程._1线程的使用;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 12:26
 * @Description 第2部分._14线程.线程的使用
 * @Version 1.0
 */
public class Thread01 {
    /*
    继承Thread
     */
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();//并不会阻塞程序
        System.out.println("主线程继续执行... 主线程名：" + Thread.currentThread().getName());

        for (int i = 0; i < 60; i++) {
            System.out.println(i + " 线程：" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
    /*
    继承Thread 本类可以作为一个线程使用
    Thread 实现里Runnable接口，从写了run()方法
     */
    static class Cat extends Thread{
        int times = 0;  //统计次数
        @Override
        public void run() { //重写run方法，写自己的逻辑
            try {
                do {
                    //输出
                    System.out.println("喵喵，我是一只小猫咪...  子线程名："+Thread.currentThread().getName() +" " + ++times);
                    //休眠1秒
                    Thread.sleep(1000);
                } while (times != 80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
