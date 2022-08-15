package 第3部分._6正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 13:31
 * @Description 演示转义字符的使用
 * @Version 1.0
 */
public class _3转义字符 {
    /*
    匹配一些符号: .  * + ( ) $ / \ ? [ ] ^ { }
    可能用到转义字符
    用两个\表示
     */
    public static void main(String[] args) {
        String s = "12(89).";
        String regStr = "\\(";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println("----------------------");
        regStr = ".";//匹配所有单个字符
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println("----------------------");
        regStr = "\\.";//匹配.号
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
