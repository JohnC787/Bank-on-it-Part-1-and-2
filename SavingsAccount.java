import java.io.Serializable;

public class SavingsAccount extends CheckingAccount implements Serializable {
    private double interestRate;

    public SavingsAccount() {
        super();
        this.interestRate = 0.05;
    }

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double rate) {
        this.interestRate = rate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double calcInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        return getBalance();
    }
    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount();
        acc.start();
    }
}
