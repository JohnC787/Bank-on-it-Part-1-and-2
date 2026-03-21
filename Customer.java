import java.util.Scanner;

public class Customer extends User {
    private CheckingAccount checking;
    private SavingsAccount savings;
    private Scanner scanner = new Scanner(System.in);

    public Customer() {
        checking = new CheckingAccount();
        savings = new SavingsAccount();
        setUserName("Alice");
        setPIN("0000");
    }

    public Customer(String userName, String PIN) {
        this();
        setUserName(userName);
        setPIN(PIN);
    }

    @Override
    public String menu() {
        return "\nCustomer Menu\n\n0) Exit\n1) Manage Checking Account\n2) Manage Savings Account\n3) change PIN\n";
    }

    @Override
    public void start() {
        if (!login()) {
            System.out.println("Login Failed");
            return;
        }

        System.out.println("Login Successful");

        int choice;
        do {
            System.out.println(menu());
            System.out.print("Action (0-3): ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Checking Account");
                    checking.start();
                    break;
                case 2:
                    System.out.println("Savings Account");
                    savings.start();
                    break;
                case 3:
                    changePin();
                    break;
            }
        } while (choice != 0);
    }

    public void changePin() {
        System.out.print("Enter new PIN: ");
        setPIN(scanner.nextLine());
        System.out.println("PIN updated.");
    }

    @Override
    public String getReport() {
        return "User: " + getUserName() +
               "\nChecking: " + checking.getBalanceString() +
               "\nSavings: " + savings.getBalanceString();
    }

    public static void main(String[] args) {
        Customer c = new Customer();
        c.start();
    }
}
