package 第3部分._6正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 挚爱之夕
 * @date 2022-01-09 - 01 - 09 - 20:17
 * @Description 正则表达式 考虑分组-group()
 * @Version 1.0
 */
public class _2Demo2 {
    public static void main(String[] args) {
        String str = "1996年1月，Sun公司发布了Java的第一个开发工具包（JDK 1.0），" +
                "这是Java发展历程中的重要里程碑，标志着Java成为一种独立的开发工具。" +
                "9月，约8.3万个网页应用了Java技术来制作。" +
                "10月，Sun公司发布了Java平台的第一个即时（JIT）编译器。\n" +
                "1997年2月，JDK 1.1面世，在随后的3周时间里，达到了22万次的下载量。" +
                "4月2日，Java One会议召开，参会者逾一万人，创当时全球同类会议规模之纪录。" +
                "9月，Java Developer Connection社区成员超过10万。";
        //目标：匹配2对2个数字
        String regStr = "(\\d\\d)(\\d\\d)";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){
            /*
            此时，find()
            以1996为例

            1.记录索引范围：（开始索引， 结束索引+1）groups[0] = 0, groups[1] = 4
            2.记录第一组范围：groups[2] = 0, groups[3] = 2
            3.记录第二组范围：groups[4] = 2, groups[5] = 4
             */
            System.out.println(matcher.group(0));//匹配到的子字符串
            System.out.println("第一组： " + matcher.group(1));//匹配到的子字符串的第一组
            System.out.println("第二组： " + matcher.group(2));//匹配到的子字符串的第二组
        }
    }

}
