package 第2部分._14线程._3线程方法;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 17:25
 * @Description 第2部分._14线程._3线程方法
 * @Version 1.0
 */
public class ThreadMethod3 {
    /*
    守护线程                thread.setDaemon(true);
    main线程作为工作线程
    子线程作为守护线程
    当主线程结束，子线程也会结束
     */
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread thread = new MyDaemonThread();
        thread.setDaemon(true); //将thread设置为main线程的守护线程
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("李白正在看武庚纪...");
            Thread.sleep(1000);
        }
        System.out.println("李白不想看了...");
    }
    static class MyDaemonThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("电视正在播放武庚纪...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
