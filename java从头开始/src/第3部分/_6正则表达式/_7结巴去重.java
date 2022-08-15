package 第3部分._6正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 8:01
 * @Description 结巴去重
 * @Version 1.0
 */
public class _7结巴去重 {
    public static void main(String[] args) {
        String s = "我我...要学...学...学学Java";
        //1.去掉所有的.
        String regStr = "\\.+";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        s = matcher.replaceAll("");
        System.out.println(s);
        //2.去重
        regStr = "(.)\\1+";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
//        while(matcher.find()){
//            System.out.println("find:" + matcher.group());
//        }
        s = matcher.replaceAll("$1");//组外反向引用
        System.out.println(s);

        //可以使用一条语句
        String result = Pattern.compile("(.)\\1+").matcher("我我要学学学学Java").replaceAll("$1");
        System.out.println(result);
    }
}
