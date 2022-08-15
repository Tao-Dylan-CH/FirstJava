package 第2部分.作业.作业05;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 16:29
 * @Description 第2部分.作业.作业05
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        new Car(10).new Air().flow();
        new Car(-1).getAir().flow();
        new Car(41).new Air().flow();
    }
}
class Car{
    private double temperature;
    public class Air{
        public void flow(){
            if(temperature < 0){
                System.out.println("吹热风...");
            }else if(temperature > 40){
                System.out.println("吹冷风...");
            }else{
                System.out.println("不吹风,关闭中...");
            }
        }
    }
    public Air getAir(){
        return new Air();
    }
    public Car(double temperature) {
        this.temperature = temperature;
    }
}