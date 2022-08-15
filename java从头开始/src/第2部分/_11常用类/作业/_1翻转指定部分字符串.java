package 第2部分._11常用类.作业;

/**
 * @author 挚爱之夕
 * @date 2021/11/19 - 11 - 19 - 19:39
 * @Description 第2部分._11常用类.作业
 * @Version 1.0
 */
public class _1翻转指定部分字符串 {
    public static void main(String[] args) {
        String s = "er1234uti";
        System.out.println("处理前：");
        System.out.println(s);
        try{
            s = reverse(s, 2, 5);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("处理后：");
        System.out.println(s);
    }
    public static String reverseString(String s, int begin, int end){
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < begin; i++) {
            stringBuffer.append(s.charAt(i));
        }
        for (int i = end; i >= begin; i--) {
            stringBuffer.append(s.charAt(i));
        }
        for (int i = end + 1; i < s.length(); i++) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

    public static String reverse(String s, int begin, int end){
        if(s == null || begin >= end || begin < 0 || end >= s.length()){
            throw new RuntimeException("参数不正确。");
        }
        char[] chars = s.toCharArray();
        char temp;
        int left = begin;
        int right = end;
        while(left < right){
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
