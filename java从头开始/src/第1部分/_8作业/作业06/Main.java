package 第1部分._8作业.作业06;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 22:42
 * @Description 第1部分._8作业.作业6
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--------CheckingAccount--------");
        CheckingAccount bankAccount = new CheckingAccount(1000);
        bankAccount.deposit(100);
        System.out.println(bankAccount.getBalance());
        bankAccount.withdraw(100);
        System.out.println(bankAccount.getBalance());
        System.out.println("---------SavingAccount---------");
        SavingAccount savingAccount = new SavingAccount(1000);
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());
        //三次后收费1美元
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());
        //月初了，重置、加利息
        System.out.println("月初了，重置、加利息....");
        savingAccount.earnMonthlyInterest();
        System.out.println(savingAccount.getBalance());
        System.out.println("取100元：");
        savingAccount.withdraw(100);
        System.out.println(savingAccount.getBalance());
        savingAccount.withdraw(100);
        System.out.println(savingAccount.getBalance());
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());
        savingAccount.deposit(100);
        System.out.println(savingAccount.getBalance());

    }
}
