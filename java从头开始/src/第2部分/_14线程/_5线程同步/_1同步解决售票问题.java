package 第2部分._14线程._5线程同步;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 21:12
 * @Description 第2部分._14线程._5线程同步
 * @Version 1.0
 */
public class _1同步解决售票问题 {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
    }

    static class SellTicket implements Runnable {
        int tickets = 100;
        private boolean loop = true;

        /*
        1.private synchronized void sell() 是同步方法，同一时刻只有一个线程执行
        2.这时锁在 this对象
        3.也可以在代码块上写synchronized，同步代码块
         */
        private /*synchronized*/ void sell() {
            synchronized (this) {
                if (tickets == 0) {
                    System.out.println("售票结束...");
                    loop = false;
                    return;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        " 窗口卖出一张票，余票为：" + (--tickets));

            }
        }

        @Override
        public void run() {
            while (loop) {
                sell();
            }
        }
    }
}
