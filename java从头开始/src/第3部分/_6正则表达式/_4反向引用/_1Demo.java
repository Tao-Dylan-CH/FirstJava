package 第3部分._6正则表达式._4反向引用;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 21:17
 * @Description 演示反向引用
 * @Version 1.0
 */
public class _1Demo {
    @Test
    //找到2个连续相同的数字
    public void f1(){
        String s = "tyu77i89l00";
        String regStr = "(\\d)\\1"; //  \\1代表1号分组
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("连续2个相同数字：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    //找到4个连续相同的数字
    public void f2(){
        String s = "tyu7777i8934l0000";
        String regStr = "(\\d)\\1{3}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("连续4个相同数字：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    //4位数字：第1位和第4位相同、第2位和第3位相同
    public void f3(){
        String s = "1221ui78i87";
        String regStr = "(\\d)(\\d)\\2\\1";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("满足条件的数字：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
