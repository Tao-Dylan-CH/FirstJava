package 第2部分._4接口;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 18:01
 * @Description 第2部分._4接口
 * @Version 1.0
 */
public class _3接口多态 {
    public static void main(String[] args) {
        //多态参数
        Usb usb = new Phone1();
        //多态数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone1();
        usbs[1] = new Camera1();
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            if(usbs[i] instanceof Phone1){
                //向下转型
                ((Phone1) usbs[i]).call();
            }
        }
    }
}
interface Usb{
    void work();
}
class Phone1 implements Usb{
    @Override
    public void work() {
        System.out.println("手机工作中...");
    }
    public void call(){
        System.out.println("用手机打电话...");
    }
}

class Camera1 implements Usb{

    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}