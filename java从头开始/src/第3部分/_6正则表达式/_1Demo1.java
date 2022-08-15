package 第3部分._6正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-09 - 01 - 09 - 19:52
 * @Description 演示正则表达式
 * @Version 1.0
 */
public class _1Demo1 {
    public static void main(String[] args) {
        String str = "1996年1月，Sun公司发布了Java的第一个开发工具包（JDK 1.0），" +
                "这是Java发展历程中的重要里程碑，标志着Java成为一种独立的开发工具。" +
                "9月，约8.3万个网页应用了Java技术来制作。" +
                "10月，Sun公司发布了Java平台的第一个即时（JIT）编译器。\n" +
                "1997年2月，JDK 1.1面世，在随后的3周时间里，达到了22万次的下载量。" +
                "4月2日，Java One会议召开，参会者逾一万人，创当时全球同类会议规模之纪录。" +
                "9月，Java Developer Connection社区成员超过10万。";
        //目标：匹配4个数字

        //1. 表达模式：\d表示任意数字
        String regStr = "\\d\\d\\d\\d";
        //2. 得到模式对象
        Pattern pattern = Pattern.compile(regStr);
        //3. 得到匹配器
        Matcher matcher = pattern.matcher(str);

        //4.匹配结果
        while(matcher.find()){
            // find() 将下面第一次满足匹配的子串索引记录在matcher属性
            // 比如第一个：1996   int[] groups; groups[0] = 0（开始索引） , groups[1] = 4（结束索引+1）
            System.out.println(matcher.group(0));
            //group(int group) 返回匹配结果
            /*
            public String group(int group) {
                if (first < 0)
                    throw new IllegalStateException("No match found");
                if (group < 0 || group > groupCount())
                    throw new IndexOutOfBoundsException("No group " + group);
                if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
                    return null;
                return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
            }
             */
        }
    }
}
