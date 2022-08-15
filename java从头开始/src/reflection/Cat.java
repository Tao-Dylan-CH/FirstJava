package reflection;

/**
 * @author 挚爱之夕
 * @date 2021-12-16 - 12 - 16 - 14:56
 * @Description reflection
 * @Version 1.0
 */
public class Cat {
    public String name = "招财猫";
    public int age = 0;
    private static int count = 0;
    public Cat(){

    }
    public Cat(String name){
        this.name = name;
    }

    private Cat(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void hi(){
//        System.out.println("hi " + name);
    }
    public void cry(){
        System.out.println(name +" 喵喵...");
    }
    private static String birthday(int y, int m, int d){
        return y + " " + m + " " + d;
    }
    public String mi(String no){
        return no;
    }
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
