package 第3部分._6正则表达式;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 15:06
 * @Description 演示限定符的使用
 * @Version 1.0
 */
public class _5限定符 {
    @Test
    public void f1(){
        //{n}
        String s = "aaa55ab";
        String regStr = "a{3}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("匹配3个a:");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //{n,}
        regStr = "a{2,}";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("匹配2到多个a:");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //{n,m}
        regStr = "a{2,3}";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("匹配2到3个a:");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    public void f2(){
        //*:0-n个
        String s = "aaa55ab";
        String regStr = "a*";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("匹配0个或多个a:");
        while(matcher.find()){
            System.out.println("find:" + matcher.group());
        }

        //+:1-n
        regStr = "a+";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("匹配1个或多个a:");
        while(matcher.find()){
            System.out.println("find:" + matcher.group());
        }

        //?:0 or 1
        regStr = "a?";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("匹配1个或0个a:");
        while(matcher.find()){
            System.out.println("find:" + matcher.group());
        }
    }
}
