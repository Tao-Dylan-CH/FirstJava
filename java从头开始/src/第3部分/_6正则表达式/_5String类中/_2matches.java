package 第3部分._6正则表达式._5String类中;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 11:52
 * @Description 验证手机号，以151、152 开头 11位数
 * @Version 1.0
 */
public class _2matches {
    public static void main(String[] args) {
        String s = "15178964536";
        if(s.matches("^(151|152)\\d{8}$")){
            System.out.println("验证成功！");
        }else{
            System.out.println("验证失败！");
        }
    }
}
