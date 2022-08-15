package 第2部分._14线程._1线程的使用;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 15:51
 * @Description 第2部分._14线程.线程的使用
 * @Version 1.0
 */
public class 模拟售票 {
    /*
    模拟三个窗口同时售票100张
     */
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
    }
    static class SellTicket implements Runnable{
        int tickets = 100;
        @Override
        public void run() {
            do{
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 窗口卖出一张票，余票为：" + (--tickets));
            }while(tickets>0);
        }
    }
}
