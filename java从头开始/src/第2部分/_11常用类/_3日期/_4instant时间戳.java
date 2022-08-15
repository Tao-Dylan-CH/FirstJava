package 第2部分._11常用类._3日期;

import java.time.Instant;
import java.util.Date;

/**
 * @author 挚爱之夕
 * @date 2021/11/18 - 11 - 18 - 22:40
 * @Description 第2部分._11常用类._3日期
 * @Version 1.0
 */
public class _4instant时间戳 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        //Date和Instant转换
        Date date = Date.from(instant);
        Instant instant1 = date.toInstant();
    }
}
