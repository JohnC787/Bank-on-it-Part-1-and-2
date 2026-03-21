public class SavingsAccount extends CheckingAccount {
    private double interestRate;

    public SavingsAccount() {
        super();
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

    public void calcInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }

    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount();
        acc.start();
    }
}
