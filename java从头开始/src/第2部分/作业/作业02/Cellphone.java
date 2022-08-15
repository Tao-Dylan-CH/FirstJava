package 第2部分.作业.作业02;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 12:45
 * @Description 第2部分.作业.作业02
 * @Version 1.0
 */
public class Cellphone {
    void testWork(ComputerInterface computerInterface, int n,int m){
        int result = computerInterface.work(n, m);
        System.out.println(result);
    }

    public static void main(String[] args) {
        new Cellphone().testWork(new ComputerInterface() {
            @Override
            public int work(int n,int m) {
                return n + m;
            }
        }, 1, 2 );
    }
}
interface ComputerInterface{
    int work(int n, int m);
}
