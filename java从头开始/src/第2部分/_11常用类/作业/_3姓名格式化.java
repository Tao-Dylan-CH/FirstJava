package 第2部分._11常用类.作业;

/**
 * @author 挚爱之夕
 * @date 2021/11/19 - 11 - 19 - 20:51
 * @Description 第2部分._11常用类.作业
 * @Version 1.0
 */
public class _3姓名格式化 {
    public static void main(String[] args) {
        String s = "Harry Potter Ron";
        System.out.println(proceed(s));
    }
    private static String proceed(String s){
        if(s == null){
            throw new RuntimeException("字符串不能为空");
        }

        String[] source = s.split(" ");
        if(source.length != 3){
            throw new RuntimeException("字符串格式非法");
        }

        char c = source[1].charAt(0);
        return source[2] + "," + source[0] + " ." + Character.toUpperCase(c);
    }
}
