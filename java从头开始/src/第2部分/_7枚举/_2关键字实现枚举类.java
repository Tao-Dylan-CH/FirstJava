package 第2部分._7枚举;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 14:18
 * @Description 第2部分._7枚举
 * @Version 1.0
 */
public class _2关键字实现枚举类 {
    public static void main(String[] args) {
        System.out.println(Seas.SPRING);
        System.out.println(Seas.SUMMER);
        System.out.println(Seas.AUTUMN);
        System.out.println(Seas.WINNER);
    }
}
//关键字实现枚举
enum Seas{
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),WINNER("冬天", "寒冷");
    //定义的常量（对象）规定写在前面
    //多个常量（对象）之间用逗号隔开
    Seas(String name, String description) {
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
