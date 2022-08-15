package 第2部分._14线程._1线程的使用;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 15:04
 * @Description 第2部分._14线程.线程的使用
 * @Version 1.0
 */
public class Thread02 {
    /*
    实现Runnable接口
     */
    public static void main(String[] args) {
        Information information = new Information();
        //由当前对象，创建一个Thread 对象
        Thread thread = new Thread(information);
        thread.start();
    }
    /*
    实现Runnable接口
     */
    static class Information implements Runnable{
        @Override
        public void run() {
            int times = 0;
            do{
                System.out.println("号外！号外！ " + Thread.currentThread().getName() +" " + ++times);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while(times!=10);
        }
    }
}
