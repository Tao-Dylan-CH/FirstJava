package 第2部分._4接口;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 16:37
 * @Description 第2部分._4接口
 * @Version 1.0
 */
public class _1接口引入 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        //接口
        Camera camera = new Camera();
        Phone phone = new Phone();
        computer.work(camera);  //相机接入到电脑
        computer.work(phone);   //手机接入到电脑
    }
}
interface UsbInterface{
    void start();
    void stop();
    //默认方法
    default void doSomething(){
        System.out.println("do something...");
    }
}
class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("我是相机，我开始工作了...");
    }

    @Override
    public void stop() {
        System.out.println("我是相机，我停止工作了...");
    }
}
class Phone implements UsbInterface{
    @Override
    public void start() {
        System.out.println("我是手机，我开始工作了...");
    }

    @Override
    public void stop() {
        System.out.println("我是手机，我停止工作了...");
    }
}
//相机、手机插入电脑接口
class Computer{
    public void work(UsbInterface usbInterface){
        usbInterface.start();
        usbInterface.stop();
    }
}
