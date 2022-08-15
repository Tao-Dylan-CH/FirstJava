package 第2部分._14线程.作业;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/26 - 11 - 26 - 22:48
 * @Description 第2部分._14线程.作业
 * @Version 1.0
 */
public class 作业02 {
    /*
    main线程中启动两个线程
    一个线程循环打印1-100的整数
    直到另一个线程输入Q
     */
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2(myThread1);
        myThread1.start();
        myThread2.start();
    }

    static class MyThread1 extends Thread {
        private boolean loop = true;
        Random random = new Random();

        public void print() {
            while (loop) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(random.nextInt(100));
            }
        }

        @Override
        public void run() {
            print();
        }

        public boolean isLoop() {
            return loop;
        }

        public void setLoop(boolean loop) {
            this.loop = loop;
        }
    }

    static class MyThread2 extends Thread {
        MyThread1 myThread1;
        Scanner scanner = new Scanner(System.in);

        public MyThread2(MyThread1 myThread1) {
            this.myThread1 = myThread1;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("输入一个Q结束线程：");
                char c = scanner.next().toUpperCase().charAt(0);
                if(c == 'Q'){
                    myThread1.setLoop(false);
                    System.out.println("线程2 退出");
                    break;
                }
            }
        }
    }
}
