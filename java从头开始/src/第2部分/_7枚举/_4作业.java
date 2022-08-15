package 第2部分._7枚举;

/**
 * @author 挚爱之夕
 * @date 2021/11/13 - 11 - 13 - 19:26
 * @Description 第2部分._7枚举
 * @Version 1.0
 */
public class _4作业 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        System.out.println("所有的星期信息如下：");
        for (Week week:weeks
             ) {
            System.out.println(week);
        }
    }
}
enum Week{
    Monday("星期一"), Tuesday("星期二"),
    Wednesday("星期三"), Thursday("星期四"),
    Friday("星期五"), Saturday("星期六"), Sunday("星期天");
    private Week(String name){
        this.name = name;
    }
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
