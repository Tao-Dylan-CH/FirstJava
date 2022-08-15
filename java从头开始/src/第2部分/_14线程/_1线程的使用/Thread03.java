package 第2部分._14线程._1线程的使用;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 15:25
 * @Description 第2部分._14线程.线程的使用
 * @Version 1.0
 */
public class Thread03 {
    /*
    两个线程同时进行
     */
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }
    static class Thread1 extends Thread{
        int times = 0;
        @Override
        public void run() {
            do {
                try{
                    System.out.println("Hello! " + Thread.currentThread().getName() + " " + ++times);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }while(times!=10);
        }
    }
    static class Thread2 extends Thread{
        int times = 0;

        @Override
        public void run() {
            do{
                System.out.println("Hi! " + Thread.currentThread().getName() + " " + ++times);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(times != 10);
        }
    }
}
