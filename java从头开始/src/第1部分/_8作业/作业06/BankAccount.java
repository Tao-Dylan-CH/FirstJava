package 第1部分._8作业.作业06;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 22:09
 * @Description 第1部分._8作业.作业6
 * @Version 1.0
 */
public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
