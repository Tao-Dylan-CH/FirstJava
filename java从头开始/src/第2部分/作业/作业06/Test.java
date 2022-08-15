package 第2部分.作业.作业06;

/**
 * @author 挚爱之夕
 * @date 2021/11/14 - 11 - 14 - 16:39
 * @Description 第2部分.作业.作业06
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Color color = Color.RED;
        color.show();
        switch (color){
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            default:
                System.out.println("无名色");
        }
    }
}
enum Color implements Show{
    RED(255,0,0),BLUE(0,0,255),
    BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);
    private final int redValue;
    private final int greenValue;
    private final int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("r:" + redValue + " g:" + greenValue + " b:" + blueValue);
    }
}
interface Show{
    void show();
}