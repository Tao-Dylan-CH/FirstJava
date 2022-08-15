package 第2部分._14线程;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 15:20
 * @Description 第2部分._14线程
 * @Version 1.0
 */
public class _2静态代理模式 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ThreadProxy thread = new ThreadProxy(tiger);
        thread.run();
    }

    static class Animal{}
    static class Tiger extends Animal implements Runnable{
        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("老虎嗷嗷叫... " + Thread.currentThread().getName());
            }
        }
    }
    /*
    用静态代理模式模拟简易Thread
     */
    static class ThreadProxy implements Runnable{
        Runnable target = null;

        public ThreadProxy(Runnable target) {
            this.target = target;
        }

        @Override
        public void run() {
            if(target != null){
                target.run();
            }
        }
        public void start(){
            start0();
        }
        public void start0(){
            run();
        }
    }
}
