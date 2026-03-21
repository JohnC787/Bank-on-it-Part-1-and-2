import java.util.Scanner;

public class CheckingAccount implements HasMenu {
    private double balance;
    private Scanner scanner = new Scanner(System.in);

    public CheckingAccount() {
        this.balance = 0.0;
    }

    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBalanceString() {
        return String.format("$%.2f", balance);
    }

    private double getDouble() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            return 0.0;
        }
    }

    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    }

    public void makeDeposit() {
        System.out.println("Making a deposit...");
        System.out.print("How much to deposit? ");
        double amount = getDouble();
        balance += amount;
        System.out.println("New balance: " + getBalanceString());
    }

    public void makeWithdrawal() {
        System.out.println("Making a withdrawal...");
        System.out.print("How much to withdraw? ");
        double amount = getDouble();
        balance -= amount;
        System.out.println("New balance: " + getBalanceString());
    }

    @Override
    public String menu() {
        return "\nAccount menu\n\n0) quit\n1) check balance\n2) make a deposit\n3) make a withdrawal\n";
    }

    @Override
    public void start() {
        int choice;
        do {
            System.out.println(menu());
            System.out.print("Please enter 0-3: ");
            choice = (int) getDouble();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    makeDeposit();
                    break;
                case 3:
                    makeWithdrawal();
                    break;
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        CheckingAccount acc = new CheckingAccount();
        acc.start();
    }
}
