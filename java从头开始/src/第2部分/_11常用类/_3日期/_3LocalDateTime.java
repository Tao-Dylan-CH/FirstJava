package 第2部分._11常用类._3日期;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 挚爱之夕
 * @date 2021/11/18 - 11 - 18 - 22:24
 * @Description 第2部分._11常用类._3日期
 * @Version 1.0
 */
public class _3LocalDateTime {
    public static void main(String[] args) {
        //返回当前日期
        LocalDateTime time = LocalDateTime.now();
        System.out.println("年：" + time.getYear());
        System.out.println("月：" + time.getMonthValue());
        System.out.println("日：" + time.getDayOfMonth());
        System.out.println("时：" + time.getHour());
        System.out.println("分：" + time.getMinute());
        System.out.println("秒：" + time.getSecond());
        System.out.println(time.getYear() + "年" + time.getMonthValue() + "月" +
                time.getDayOfMonth() + "日  " + time.getHour() + ":" +
                time.getMinute() + ":" + time.getSecond());

        //第三代日期类支持格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(time));
        //只用日期，LocalDate
        LocalDate time1 = LocalDate.now();
        //只用时间，LocalTime
        LocalTime time2 = LocalTime.now();

        //提供plus 和 minus 方法可以对当前日期进行加减
        LocalDateTime localDateTime = time.plusDays(1000);
        System.out.println("1000天后：" + formatter.format(localDateTime));
        LocalDateTime localDateTime1 = time.minusDays(1000);
        System.out.println("1000天前：" + formatter.format(localDateTime1));
    }
}
