package 第2部分._14线程.作业;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 17:11
 * @Description 第2部分._14线程.作业
 * @Version 1.0
 */
public class 作业01 {
    /*
    主线程打印5次hi
    启动子线程
    子线程结束后
    主线程继续
     */
    public static void main(String[] args) throws InterruptedException {
        sayHello sayHello = new sayHello();
        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if(i == 5){
                Thread thread = new Thread(sayHello);
                thread.start();
                thread.join();
            }
        }
        System.out.println("主线程结束...");
    }
    static class sayHello implements Runnable{
        
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("hello " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("子线程结束...");
        }
    }
}
