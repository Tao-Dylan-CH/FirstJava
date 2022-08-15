package 第3部分._6正则表达式;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 13:45
 * @Description 演示字符匹配符的使用
 * @Version 1.0
 */
public class _4字符匹配符 {
    @Test
    public void f1(){// []:可接受字符集
        //小写字母
        String s = "8bqQQ";
        String regStr = "[a-z]";//匹配a-z之间任意一个字符
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("小写字母：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //大写字母
        System.out.println("大写字母：");
        regStr = "[A-Z]";//匹配A-Z之间任意一个字符
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //大写或小写字母
        System.out.println("大写或小写字母：");
        regStr = "(?i)[a-z]";//匹配字母，(?i)表示不区分大小写
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        //通过pattern指定不区分大小写
        System.out.println("-------------------");
        regStr = "[a-z]";
        pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //匹配非字母
        System.out.println("非字母：");
        regStr = "[^a-z]";
        pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    @Test
    public void f2(){
        //字符集中任意一个
        String s = "1q2t 6u_%";
        String regStr = "[qtP]";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        System.out.println("qtP中的任意一个：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //不在字符集中的任意一个
        regStr = "[^qt]";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("不是qt的任意一个：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //匹配一个数字
        regStr = "\\d";//表示一个数字：相当于[0-9]
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("任意一个数字：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //匹配非数字
        regStr = "\\D";//表示非数字：相当于[^0-9]
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("任意一个非数字：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //匹配任意英文字符、数字和下划线
        regStr = "\\w";//相当于：[0-9a-zA-Z_]
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("任意英文字符、数字和下划线：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //取反匹配任意英文字符、数字和下划线
        regStr = "\\W";//相当于：[^0-9a-zA-Z_]
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("不是任意英文字符、数字和下划线：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

        //匹配空白符
        regStr = "\\s";
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("空白符：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println("--------------");

        //匹配除\n外的任意字符，匹配.需要 \\.
        regStr = ".";//相当于：[^0-9a-zA-Z_]
        pattern = Pattern.compile(regStr);
        matcher = pattern.matcher(s);
        System.out.println("任意字符：");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
        System.out.println("--------------");
    }
    @Test
    public void f3(){//选择匹配符
        String s = "清华 北大 上交 中科大";
        String regStr = "清华|北大";//匹配清华或北大
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
