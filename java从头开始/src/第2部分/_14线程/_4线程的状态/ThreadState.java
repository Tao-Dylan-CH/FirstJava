package 第2部分._14线程._4线程的状态;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 17:52
 * @Description 第2部分._14线程._4线程的状态
 * @Version 1.0
 */
public class ThreadState {
    /*
    输出线程状态
    演示
    NEW
    RUNNABLE
    TIMED_WAITING
    TERMINATED
     */
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println("当前线程状态：" + t.getState());
        t.start();
        while(t.getState() != Thread.State.TERMINATED){
            System.out.println("当前线程状态：" + t.getState());
            Thread.sleep(1000);
        }
        System.out.println("当前线程状态：" + t.getState());
    }
    static class T extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("当前线程状态：" + Thread.currentThread().getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
