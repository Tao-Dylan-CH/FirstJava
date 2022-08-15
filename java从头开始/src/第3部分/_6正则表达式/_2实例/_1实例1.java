package 第3部分._6正则表达式._2实例;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-11 - 01 - 11 - 19:51
 * @Description 正则表达式应用实例
 * @Version 1.0
 */
public class _1实例1 {
    @Test
    public void f1(){//匹配汉字
        String s = "仰天大笑出门去";
        String regStr = "^[\u0391-\uffe5]+$";//表示汉字范围
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println("满足格式");
        }else{
            System.out.println("不满足格式");
        }
    }
    @Test
    public void f2(){//邮政编码：1-9 开头的一个6位数
        String s = "123456";
        String regStr = "^[1-9]\\d{5}$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println("满足格式");
        }else{
            System.out.println("不满足格式");
        }
    }
    @Test
    public void f3(){//QQ号：1-9 开头的一个5-10位数
        String s = "123456";
        String regStr = "^[1-9]\\d{4,9}$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println("满足格式");
        }else{
            System.out.println("不满足格式");
        }
    }
    @Test
    public void f4(){//手机号：13、14、15、18 开头的一个11位数
        String s = "13456278901";
        String regStr = "^1[3|4|5|8]\\d{9}$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            System.out.println("满足格式");
        }else{
            System.out.println("不满足格式");
        }
    }
}
