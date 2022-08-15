package 第3部分._6正则表达式;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 15:28
 * @Description 演示定位符的使用
 * @Version 1.0
 */
public class _6定位符 {
    @Test
    public void f1(){
        //^:指定起始字符
        String s = "123abc";
        String regStr = "^\\d+[a-z]*";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("1到多个数字开头，后跟任意个小写字母：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        //$：指定结束字符
        regStr = "^\\d+[a-z]*$";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("1到多个数字开头，以任意个小写字母结尾：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    public void f2(){
        // \\b匹配边界
        String s = "moneyThemoney tmoney";
        String regStr = "money\\b";//以money为边界，后面有空格也视为边界
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){//第2个和第3个
            System.out.println(matcher.group());
        }

        // \\B匹配非边界
        regStr = "money\\B";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("-------------------------------");
        while(matcher.find()){//第1个
            System.out.println(matcher.group());
        }
    }
}
