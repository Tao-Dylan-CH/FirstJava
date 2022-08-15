package 第3部分._6正则表达式._1语法;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 19:35
 * @Description 第3部分._6正则表达式._1语法
 * @Version 1.0
 */
public class _3非贪婪匹配 {
    public static void main(String[] args) {
        String s = "1231";
        String regStr = "\\d+?";//后跟?表示非贪婪匹配:取尽可能少的字符串
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
