package 第1部分._8作业.作业06;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 22:13
 * @Description 第1部分._8作业.作业6
 * @Version 1.0
 */
public class CheckingAccount extends BankAccount{
    private double serviceCharge = 1;
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double account) {
        //少存一美元
        super.deposit(account - serviceCharge);
        //一美元存入银行
    }

    @Override
    public void withdraw(double amount) {
        //多扣一美元
        super.withdraw(amount + serviceCharge);
        //一美元存入银行
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
