package 第3部分._6正则表达式._3常用类;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 20:57
 * @Description Pattern 类
 * @Version 1.0
 */
public class _1Pattern {
    public static void main(String[] args) {
        String s = "145ui";
        String regStr = "^1.*";
        //1.得到Pattern对象
        Pattern pattern = Pattern.compile(regStr);
        //2.得到匹配器
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        //3.完全匹配
        System.out.println(Pattern.matches(regStr, s));
    }
}
