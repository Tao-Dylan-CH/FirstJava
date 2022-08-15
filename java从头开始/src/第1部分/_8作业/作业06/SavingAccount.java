package 第1部分._8作业.作业06;

/**
 * @author 挚爱之夕
 * @date 2021/11/8 - 11 - 08 - 22:16
 * @Description 第1部分._8作业.作业6
 * @Version 1.0
 */
public class SavingAccount extends BankAccount{
    private int freeChoice = 3;
    private double rate = 0.01;
    private double serviceCharge = 1;
    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }
    public void earnMonthlyInterest(){  //月初统计利息，重置免手续次数
        freeChoice = 3;
        super.deposit(getBalance() * rate);
    }

    @Override
    public void deposit(double amount) {
        if(freeChoice > 0){
            super.deposit(amount);
            freeChoice--;
        }else{
            super.deposit(amount - serviceCharge);
        }
    }

    @Override
    public void withdraw(double amount) {
        if(freeChoice > 0){
            super.withdraw(amount);
            freeChoice--;
        }else{
            super.deposit(amount + serviceCharge);
        }
    }

    public int getFreeChoice() {
        return freeChoice;
    }

    public void setFreeChoice(int freeChoice) {
        this.freeChoice = freeChoice;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
