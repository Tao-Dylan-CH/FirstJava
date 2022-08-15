package 第2部分._14线程._3线程方法;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 16:29
 * @Description 第2部分._14线程._3线程方法
 * @Version 1.0
 */
public class ThreadMethod1 {
    /*
    setName
    Priority
    sleep
    getName
    interrupt
     */
    public static void main(String[] args) throws InterruptedException {
        Eat eat = new Eat();
        eat.setPriority(Thread.MIN_PRIORITY);
        System.out.println("优先级：" + eat.getPriority());
        eat.setName("李白");
        eat.start();
        Thread.sleep(1000 * 2);
        eat.interrupt();
    }
    static class Eat extends Thread{
        int count;
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "吃包子数：" + ++count);
            }
            try {
                Thread.sleep(1000 * 20);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断了...");
            }
            for (int i = 0; i < 4; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "吃包子数：" + ++count);
            }
            System.out.println(Thread.currentThread().getName() + " 吃饱了...");
        }
    }
}
