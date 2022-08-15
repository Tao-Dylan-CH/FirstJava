package 第3部分._6正则表达式._5String类中;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 11:46
 * @Description 将字符串中的jdk1.3、jdk1.4替换为JDK
 * @Version 1.0
 */
public class _1replaceAll {
    public static void main(String[] args) {
        String content = "2000年5月，Java中的jdk1.3、jdk1.4相继发布";
        System.out.println(content.replaceAll("jdk1\\.3|jdk1\\.4", "JDK"));
    }
}
