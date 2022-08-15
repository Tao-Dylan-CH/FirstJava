package 第3部分._6正则表达式._3常用类;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 21:04
 * @Description Matcher类
 * @Version 1.0
 */
public class _2Matcher {
    public static void main(String[] args) {
        String s = "145ui345";
        String regStr = "\\d{3}";
        Pattern pattern = Pattern.compile(regStr);

        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            //1.start()、end()
            int start = matcher.start();//满足匹配子串的开始索引
            int end = matcher.end();//满足匹配子串的结束索引+1
            System.out.println(start + "\t" + end);
            System.out.println(s.substring(start, end));
            System.out.println(matcher.group());
        }
        //2.替换字符串,返回副本
        System.out.println("替换后：");
        String newString = matcher.replaceAll("666");
        System.out.println(newString);

    }
}
