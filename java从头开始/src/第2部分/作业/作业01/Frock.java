package 第2部分.作业.作业01;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 12:29
 * @Description 第2部分.作业.作业01
 * @Version 1.0
 */
public class Frock {
    private static int currentNum = 100000;
    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }
    private int serialNumber;

    public int getSerialNumber() {
        return serialNumber;
    }

    public Frock() {
        this.serialNumber = getNextNum();
    }
}
class Test{
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock f1 = new Frock();
        Frock f2 = new Frock();
        Frock f3 = new Frock();
        System.out.println(f1.getSerialNumber());
        System.out.println(f2.getSerialNumber());
        System.out.println(f3.getSerialNumber());

    }
}
