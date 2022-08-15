package 第3部分._6正则表达式._4反向引用;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 21:27
 * @Description 第3部分._6正则表达式._4反向引用
 * @Version 1.0
 */
public class _3应用 {
    public static void main(String[] args) {
        /*
        请在字符中检索商品编号,形式如:12321-333999111这样的号码
        要求满足前面是一个五位数,然后一个号,然后是一个九位数,连续的每三位要相同
         */
        String s = "qqqqqqqqq12321-333999111ee";
        String regStr = "\\d{5}-((\\d)\\2{2}){3}";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
