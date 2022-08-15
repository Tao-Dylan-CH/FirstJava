package 第3部分._6正则表达式._2实例;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 20:11
 * @Description 验证URL
 * @Version 1.0
 */
public class _2实例2验证URL {
    public static void main(String[] args) {
        String s = "https://www.bilibili.com/video/BV1fh411y7R8?p=18&spm_id_from=pageDriverP27";
        /*
        1.先写开头：https:// or http://      ^((http|https)://)
        2.匹配域名：www.bilibili.com         ([\w-]+\.)+([\w-]+
        3.后面    [.]表示的就是.本身
         */
        String regStr = "^((http|https)://)([\\w-]+\\.)+([\\w-]+(\\/[\\w-?&=/#%.]*)?$)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println("匹配成功");
        }else{
            System.out.println("匹配失败");
        }

        //使用matches()
        System.out.println(Pattern.matches(regStr, s));
    }
}
