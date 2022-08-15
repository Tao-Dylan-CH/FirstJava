package 第2部分._14线程._2线程的终止;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 16:03
 * @Description 第2部分._14线程._2线程的终止
 * @Version 1.0
 */
public class _1ThreadExit {
    public static void main(String[] args) {
        /*
        通过通知方式：改变变量
        终止子线程
         */
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName() + " 休眠5秒...");
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.setLoop(false);
        System.out.println(Thread.currentThread().getName() + " 休眠结束，终止子线程...");
    }
    static class MyThread extends Thread{
        private int count;
        private boolean loop = true;    //定义变量，主线程通过通知方式，终止子线程
        @Override
        public void run() {
            while(loop){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" 子线程运行中... " + ++count);
            }
        }

        public boolean isLoop() {
            return loop;
        }

        public void setLoop(boolean loop) {
            this.loop = loop;
        }
    }
}
