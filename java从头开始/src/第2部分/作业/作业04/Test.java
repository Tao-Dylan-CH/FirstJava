package 第2部分.作业.作业04;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 13:12
 * @Description 第2部分.作业.作业04
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Person tang = new Person("唐僧",VehicleFactory.getHorse());
        tang.common();
        tang.passRiver();
        tang.common();
        tang.passFireMountain();
    }
}
interface Vehicle{
    void work();
}
class Horse implements Vehicle{
    @Override
    public void work() {
        System.out.println("正常情况下骑马...");
    }
}
class Boat implements Vehicle{
    @Override
    public void work() {
        System.out.println("遇到河坐船...");
    }
}
class Monkey implements Vehicle{
    @Override
    public void work() {
        System.out.println("遇到火焰山，骑猴过山...");
    }
}
class VehicleFactory{
    //用同一匹马
    private static Horse horse = new Horse();
    private static Monkey sunWuKong = new Monkey();
    public static Horse getHorse(){
        return horse;
    }
    //可以是不同的船
    public static Boat getBoat(){
        return new Boat();
    }
    //就一个大徒弟悟空
    public static Monkey getSunWuKong(){
        return sunWuKong;
    }
    //构造器私有化
    private VehicleFactory(){

    }
}
class Person{
    String name;
    Vehicle vehicles;

    public Person(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicles = vehicle;
    }
    public void passRiver(){
        //vehicles == null || vehicles instanceof Horse
        if(!(vehicles instanceof Boat)){
           vehicles = VehicleFactory.getBoat();
        }
        vehicles.work();
    }
    public void common(){
        //vehicles == null || vehicles instanceof Boat
        if(!(vehicles instanceof Horse)){
            vehicles = VehicleFactory.getHorse();
        }
        vehicles.work();
    }
    public void passFireMountain(){
        if(!(vehicles instanceof Monkey)){
            vehicles = VehicleFactory.getSunWuKong();
        }
        vehicles.work();
    }
}