package 第3部分._6正则表达式._1语法;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 18:47
 * @Description 演示非捕获分组
 * @Version 1.0
 */
public class _2特别分组 {
    @Test
    //匹配 张无忌张三丰张飞
    public void f1(){//?:
        String s = "张无忌张三丰李明张飞王小二";
//        String regStr = "张无忌|张三丰|张飞";
        String regStr = "张(?:无忌|三丰|飞)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    //匹配 后跟大侠 or 同学 的 郭靖
    public void f2(){//?=
        String s = "郭靖大侠郭靖老师张飞郭靖同学";
        String regStr = "郭靖(?=大侠|同学)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    @Test
    //匹配 不是后跟大侠 or 同学 的 郭靖
    public void f3(){//?!
        String s = "郭靖大侠郭靖老师张飞郭靖同学";
        String regStr = "郭靖(?!大侠|同学)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
