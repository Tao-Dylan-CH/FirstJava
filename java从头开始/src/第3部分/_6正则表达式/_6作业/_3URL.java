package 第3部分._6正则表达式._6作业;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 14:50
 * @Description 匹配、解析URL
 * @Version 1.0
 */
public class _3URL {
    public static void main(String[] args) {
        String s = "https://www.souhu.com:8808/abc/index.htm";
        String regStr = "^([a-zA-Z]+)://([a-zA-z.]+):(\\d+)[\\w/-]*/([\\w.]+)$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        if(matcher.matches()){
            System.out.println("匹配成功！");
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口号：" + matcher.group(3));
            System.out.println("文件：" + matcher.group(4));
        }else{
            System.out.println("匹配失败！");
        }
    }
}
