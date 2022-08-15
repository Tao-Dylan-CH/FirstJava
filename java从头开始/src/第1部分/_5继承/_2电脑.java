package 第1部分._5继承;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 15:58
 * @Description 第1部分._5继承
 * @Version 1.0
 */
public class _2电脑 {
    public static void main(String[] args) {
        Pc pc = new Pc("intel","600G","i-5","lenovo");
        NotePad notePad = new NotePad("intel","600G","i-5","black");
        pc.printInformation();
        notePad.printInformation();
    }

}
class Computer{
    protected String CPU;
    protected String internalStorage;
    protected String hardDisk;

    public Computer(String CPU, String internalStorage, String hardDisk) {
        this.CPU = CPU;
        this.internalStorage = internalStorage;
        this.hardDisk = hardDisk;
    }
    public void printInformation(){
        System.out.println("CPU: " + CPU + ",internal storage: " +internalStorage+",hard disk: "+hardDisk);
    }

    public String getCPU() {
        return CPU;
    }

    public String getInternalStorage() {
        return internalStorage;
    }

    public String getHardDisk() {
        return hardDisk;
    }
}
class Pc extends Computer{
    private String brand;

    public Pc(String CPU, String internalStorage, String hardDisk, String brand) {
        super(CPU, internalStorage, hardDisk);
        this.brand = brand;
    }

    @Override
    public void printInformation() {
        super.printInformation();
        System.out.println("brand:"+brand);
    }
}
class NotePad extends Computer{
    private String color;

    public NotePad(String CPU, String internalStorage, String hardDisk, String color) {
        super(CPU, internalStorage, hardDisk);
        this.color = color;
    }

    @Override
    public void printInformation() {
        super.printInformation();
        System.out.println("color:"+color);
    }
}
