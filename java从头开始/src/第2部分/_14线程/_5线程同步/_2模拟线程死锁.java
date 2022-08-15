package 第2部分._14线程._5线程同步;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 22:00
 * @Description 第2部分._14线程._5线程同步
 * @Version 1.0
 */
public class _2模拟线程死锁 {
    /*
    模拟线程死锁
     */
    public static void main(String[] args) {
        new DeadLockDemo(true).start();
        new DeadLockDemo(false).start();
    }
    static class DeadLockDemo extends Thread{
        //保证多线程，共享一个对象，使用static
        static Object o1 = new Object();
        static Object o2 = new Object();
        boolean flag;
        public DeadLockDemo(boolean flag){
            this.flag = flag;
        }

        @Override
        public void run() {
            /*
            1.如果fLag 为 T，线程A 就会先得到/持有 o1 对象锁，然后尝试去获取 o2对象锁
            2.如果线程A 得不到o2对象锁，就会BLocked
            3.如果flag 为 F，线程B 就会先得到/持有 o2 对象锁，然后尝试去获取o1 对象锁
            4.如果线程B 得不到 o1 对象锁，就会BLocked
             */
            if(flag){
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName() + "进入t1");
                    synchronized (o2){
                        System.out.println(Thread.currentThread().getName() + "进入t2");
                    }
                }
            }else{
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName() + "进入f1");
                    synchronized (o1){
                        System.out.println(Thread.currentThread().getName() + "进入f2");
                    }
                }
            }
        }
    }
}
