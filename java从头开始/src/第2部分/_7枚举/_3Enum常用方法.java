package 第2部分._7枚举;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 18:59
 * @Description 第2部分._7枚举
 * @Version 1.0
 */
public class _3Enum常用方法 {
    public static void main(String[] args) {
        Season2 spring = Season2.SPRING;
        //1.输出枚举类的名字，Enum类toString()返回的是name
        System.out.println(spring.name());
        //2.ordinal()返回的是该枚举对象的编号/次序，从0开始
        System.out.println(spring.ordinal());
        //3.values()返回包含枚举类所有常量的数组
        Season2[] values = Season2.values();
        for (Season2 season:values
             ) {
            System.out.println(season);
        }
        System.out.println("------------------------");
        //4.由字符串，返回对应的枚举常量，如果枚举类没有该名称的常量，则抛异常
        System.out.println(Season2.valueOf("SPRING"));
        //5.比较两个枚举常量，比较的是序列号,也就是两个序列号相减
        System.out.println(Season2.SPRING.compareTo(Season2.AUTUMN));
    }
}
enum Season2{
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),WINNER("冬天", "寒冷");
    //定义的常量（对象）规定写在前面
    //多个常量（对象）之间用逗号隔开
    Season2(String name, String description) {
        this.name = name;
        this.description = description;
    }
    String name;
    String description;
    @Override
    public String toString() {
        return "name：" + name + " description：" + description;
    }
}