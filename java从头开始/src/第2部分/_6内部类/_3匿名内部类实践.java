package 第2部分._6内部类;

/**
 * @author 挚爱之夕
 * @date 2021/11/12 - 11 - 12 - 21:06
 * @Description 第2部分._6内部类
 * @Version 1.0
 */
public class _3匿名内部类实践 {
    public static void f(Il il){
        il.show();
        //方法形参是一个接口类型，使用匿名类
        new CellPhone().alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        new CellPhone().alarmClock(new Bell(){
           public void ring(){
               System.out.println("小伙伴上课了");
           }
        });
    }
    public static void main(String[] args) {
        f(new Il(){
            @Override
            public void show() {
                System.out.println("这是一个接口实例");
            }
        });
    }
}
interface Il{
    void show();
}
//手机闹铃
interface Bell{
    void ring();
}
class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}
