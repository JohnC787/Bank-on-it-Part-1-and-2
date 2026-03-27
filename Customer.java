import java.util.Scanner;
import java.io.Serializable;

public class Customer extends User implements Serializable {
    private CheckingAccount checking;
    private SavingsAccount savings;

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
        Scanner scanner = new Scanner(System.in);
    
        if (!login()) {
            System.out.println("Login Failed");
            return;
        }
    
        System.out.println("Login Successful");
    
        int choice;
        do {
            System.out.println(menu());
            System.out.print("Action (0-3): ");
    
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                choice = 0;
            }
    
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
        Scanner scanner = new Scanner(System.in);
    
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
