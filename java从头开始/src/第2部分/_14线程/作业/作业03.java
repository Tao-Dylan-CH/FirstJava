package 第2部分._14线程.作业;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 23:17
 * @Description 第2部分._14线程.作业
 * @Version 1.0
 */
public class 作业03 {
    /*
    模拟两人在同一个取款机取款
    取款机有10000元
    每次取1000元
    余额0不能再取
    线程结束
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        new Thread(atm).start();
        new Thread(atm).start();
    }
    static class ATM implements Runnable{
        static int balance = 10000;
        private boolean loop = true;
        public synchronized void getMoney(){
            if(balance <= 0){
                loop = false;
                System.out.println("余额不足...");
                return;
            }
            System.out.println(Thread.currentThread().getName() +
                    "取款1000元" + " 余额：" + (balance -= 1000));
        }
        @Override
        public void run() {
            while(loop){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getMoney();
            }
        }
    }
}
