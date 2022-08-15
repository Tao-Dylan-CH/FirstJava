package 第2部分._10常用包装类;

/**
 * @author 挚爱之夕
 * @date 2021/11/16 - 11 - 16 - 21:24
 * @Description 第2部分.常用包装类
 * @Version 1.0
 */
public class _5字符串格式化 {
    public static void main(String[] args) {
        String name = "李白";
        int age = 18;
        String sex = "男";
        double score = 200.0/3;
        String s = "name:" + name +" age:" + age + " sex:"+sex;
        System.out.println(s);
        String formatStr = "姓名: %s 年龄: %d 性别: %s 成绩： %.2f";
        s = String.format(formatStr,name,age,sex,score);
        System.out.println(s);
    }
}
