package 第3部分._6正则表达式._6作业;

/**
 * @author 挚爱之夕
 * @date 2022-01-12 - 01 - 12 - 13:06
 * @Description 验证邮箱
 * @Version 1.0
 */
public class _1验证邮箱 {
    public static void main(String[] args) {
        /*
        一个@
        @前：用户名 可包含：数字、字母、下划线、-
        @后：域名 可包含：字母.
         */
        String s = "34027@qq.com";
        String regStr = "[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";
        if(s.matches(regStr)){
            System.out.println("符合邮箱格式！");
        }else{
            System.out.println("不符合邮箱格式！");
        }
    }
}
