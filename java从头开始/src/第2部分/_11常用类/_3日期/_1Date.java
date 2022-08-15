package 第2部分._11常用类._3日期;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 挚爱之夕
 * @date 2021/11/18 - 11 - 18 - 21:31
 * @Description 第2部分._11常用类._3Date
 * @Version 1.0
 */
public class _1Date {
    public static void main(String[] args) throws ParseException {
        //1.创建Date对象
        Date date = new Date();
        Date date1 = new Date(0);
        System.out.println(date);
        System.out.println(date1);
        //2.格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日 hh:mm:ss E");
        //输出
        System.out.println(sdf.format(date));
        System.out.println(sdf.format(date1));

        //3.把格式化的字符串解析为对应的Date
        Date parse = sdf.parse("1970年-01月-02日 11:46:39 星期五");
        System.out.println(parse);
    }
}
