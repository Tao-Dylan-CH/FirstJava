package 第2部分._7枚举;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 13:52
 * @Description 第2部分._7枚举
 * @Version 1.0
 */
public class _1枚举引入 {
    public static void main(String[] args) {
        Season1 spring = new Season1("春天", "温暖");
        Season1 summer = new Season1("夏天", "炎热");
        Season1 autumn = new Season1("秋天", "凉爽");
        Season1 winner = new Season1("冬天", "寒冷");
        //季节是有四个，是固定的，这样设计不好
        System.out.println(Season.AUTUMN);
    }
}
//自定义枚举类
class Season{
    /*
    1.构造器私有化
    2.没有set方法，不允许外部修改
    3.内部创建固定的对象
     */
    String name;
    String description;
    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //加上final，使用时不会加载类，而且不能修改
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINNER = new Season("冬天", "寒冷");

    @Override
    public String toString() {
        return "name：" + name + " description：" + description;
    }
}


class Season1{
    String name;
    String description;
    public Season1(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

