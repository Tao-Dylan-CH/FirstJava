package 第2部分._11常用类.作业;

import java.util.Scanner;

/**
 * @author 挚爱之夕
 * @date 2021/11/19 - 11 - 19 - 20:01
 * @Description 第2部分._11常用类.作业
 * @Version 1.0
 */
public class _2账号注册 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入用户名：");
            String account = scanner.next();
            System.out.println("输入密码：");
            String password = scanner.next();
            System.out.println("输入邮箱：");
            String mail = scanner.next();
            register(account, password, mail);
            System.out.println("注册成功！");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void register(String account, String password, String mail) throws IllegalArgumentException {
        if(!(account.length() >= 2 && account.length()<=4)){
            throw new IllegalArgumentException("用户名长度非法，需要在在2-4之间");
        }

        if(!(password.length() == 6 && isDigital(password)))
            throw new IllegalArgumentException("密码非法，需要6位数字");

        int index1 = mail.indexOf('@');
        int index2 = mail.indexOf('.');
        if(!(index1 > 0 && index2 > index1))
            throw new IllegalArgumentException("邮箱非法，需要'@'和'.',且'@'在'.'之前 ");
    }

    public static boolean isDigital(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length; i++) {
            if(chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }
}
