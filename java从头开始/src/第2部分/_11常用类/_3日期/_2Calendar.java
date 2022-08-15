package 第2部分._11常用类._3日期;

import java.util.Calendar;

/**
 * @author 挚爱之夕
 * @date 2021/11/18 - 11 - 18 - 21:56
 * @Description 第2部分._11常用类._3日期
 * @Version 1.0
 */
public class _2Calendar {
    public static void main(String[] args) {
        //1.Calendar是抽象类，且构造器是受保护的，用getInstance()得到Calendar对象
        Calendar calendar = Calendar.getInstance();
        //Calendar提供了大量方法和字段，没有提供对应的格式化类，需要自己组合来输出

        //得到字段
        System.out.println("年：" + calendar.get(Calendar.YEAR));
        System.out.println("月：" + (calendar.get(Calendar.MONTH)+1));
        System.out.println("日：" + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时:" + calendar.get(Calendar.HOUR));
        System.out.println("分钟:" + calendar.get(Calendar.MINUTE));
        System.out.println("秒：" + calendar.get(Calendar.SECOND));
        //组合
        System.out.println(calendar.get(Calendar.YEAR)+ "年" +
                (calendar.get(Calendar.MONTH) + 1) + "月" +
                calendar.get(Calendar.DAY_OF_MONTH) + "日   " +
                calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":" +
                calendar.get(Calendar.SECOND));

    }
}
