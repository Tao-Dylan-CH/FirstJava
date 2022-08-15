package 第1部分._4封装;

/**
 * @author 挚爱之夕
 * @date 2021/11/6 - 11 - 06 - 11:25
 * @Description 第1部分._4封装
 * @Version 1.0
 */
public class _2账户管理 {
    public static void main(String[] args) {
        Count count = new Count("李四",1,"1223456");
        System.out.println(count.toString());
        System.out.println(count.getBalance());
    }
}
class Count{
    private String name;
    private double balance;
    private String password;

    public Count(){

    }

    public Count(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() == 2||name.length() == 3||name.length() == 4){
            this.name = name;
        }else{
            this.name = "无名";
            System.out.println("名字的可选长度为3、4、5,已经默认设置为无名。");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance>=20){
            this.balance = balance;
        }else{
            this.balance = 0;
            System.out.println("账号余额至少需要20,已经默认设置为0。");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() == 6){
            this.password = password;
        }else{
            this.password = "000000";
            System.out.println("密码长度必须为6，已经默认设为000000。");
        }
    }

    @Override
    public String toString() {
        return "Count{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}