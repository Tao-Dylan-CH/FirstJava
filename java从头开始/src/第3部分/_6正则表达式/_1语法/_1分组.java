package 第3部分._6正则表达式._1语法;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 18:35
 * @Description 演示捕获分组
 * @Version 1.0
 */
public class _1分组 {
    @Test
    public void f1(){//非命名分组
        String s = "12t76u";
        String regStr = "(\\d)(\\d)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println("find：" + matcher.group());
            System.out.println("第1组：" + matcher.group(1));
            System.out.println("第2组：" + matcher.group(2));
        }
    }

    @Test
    public void f2(){//命名分组
        String s = "12t56i";
        String regStr = "(?<name1>\\d)(?<name2>\\d)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            int i = 0;
            System.out.println("find：" + matcher.group());
            //可以通过组名获取
            System.out.println("第1组：" + matcher.group("name1"));
            System.out.println("第2组：" + matcher.group("name2"));
        }
    }
}
