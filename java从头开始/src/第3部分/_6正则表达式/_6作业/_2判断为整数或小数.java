package 第3部分._6正则表达式._6作业;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 13:17
 * @Description 第3部分._6正则表达式._6作业
 * @Version 1.0
 */
public class _2判断为整数或小数 {
    public static void main(String[] args) {
        String s = "0.1231";
        String regStr = "^[-]?([1-9]\\d*|0)(\\.?\\d+)?$";
        if(s.matches(regStr)){
            System.out.println("是整数或小数...");
        }else{
            System.out.println("不是整数，也不是小数...");
        }
    }
}
