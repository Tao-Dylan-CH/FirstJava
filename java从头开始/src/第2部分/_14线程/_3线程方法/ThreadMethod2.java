package 第2部分._14线程._3线程方法;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 16:49
 * @Description 第2部分._14线程._3线程方法
 * @Version 1.0
 */
public class ThreadMethod2 {
    /*
    yield   让出CPU，资源紧张的时候概率大，但礼让的时间不确定，所以也不一定礼让成功
    join    插队，先执行完
     */
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss();
        boss.start();
        for (int i = 1; i < 8; i++) {
            System.out.println("主线程（小弟） 吃了 " + i + " 个包子...");
            Thread.sleep(1000);
            if(i == 5){
                System.out.println("主线程（小弟）让子线程（老大） 先吃...");
                boss.join();    //插队，一定先于当前线程执行完
//                Thread.yield();   //礼让，不一定让出
                System.out.println("子线程（老大） 吃饱了，主线程（小弟）继续吃...");
            }
        }
        System.out.println("包子吃完了...");
    }
    static class Boss extends Thread{
        @Override
        public void run() {
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程（老大） 吃了 " + i + " 个包子...");
            }
        }
    }
}
