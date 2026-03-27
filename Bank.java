import java.util.Scanner;
import java.io.*;

public class Bank implements HasMenu {

    private Admin admin;
    private CustomerList customers;

    public Bank() {
        admin = new Admin();

        // Uncomment these TWO lines ONE TIME if you change classes
        // loadSampleCustomers();
        // saveCustomers();

        loadCustomers();
        start();
        saveCustomers();
    }

    @Override
    public void menu() {
        System.out.println("\nBank Menu");
        System.out.println("0) Exit system");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as customer");
        System.out.print("Action: ");
    }

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (admin.login()) {
                        adminStart();
                    } else {
                        System.out.println("Invalid admin login.");
                    }
                    break;

                case 2:
                    customerLogin();
                    break;
            }

        } while (choice != 0);
    }

    // ================= ADMIN MENU =================
    public void adminStart() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            admin.menu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    fullCustomerReport();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    applyInterest();
                    break;
            }

        } while (choice != 0);
    }

    // ================= CUSTOMER LOGIN =================
    public void customerLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("User name: ");
        String name = sc.nextLine();

        System.out.print("PIN: ");
        String pin = sc.nextLine();

        for (Customer c : customers) {
            if (c.login(name, pin)) {
                c.start();
                return;
            }
        }

        System.out.println("Customer not found.");
    }

    // ================= ADMIN FUNCTIONS =================
    public void fullCustomerReport() {
        System.out.println("\nFull customer report");
        for (Customer c : customers) {
            System.out.println(c.getReport());
        }
    }

    public void addUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nAdd User");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("PIN: ");
        String pin = sc.nextLine();

        customers.add(new Customer(name, pin));
    }

    public void applyInterest() {
        System.out.println("\nApply interest");

        for (Customer c : customers) {
            double newBalance = c.getSavings().calcInterest();
            System.out.printf("New balance: $%.2f\n", newBalance);
        }
    }

    // ================= SAMPLE DATA =================
    public void loadSampleCustomers() {
        customers = new CustomerList();

        Customer a = new Customer("Alice", "1111");
        a.getChecking().deposit(1000);
        a.getSavings().deposit(1000);

        Customer b = new Customer("Bob", "2222");
        Customer c = new Customer("Cindy", "3333");

        customers.add(a);
        customers.add(b);
        customers.add(c);
    }

    // ================= SERIALIZATION =================
    public void saveCustomers() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("customers.dat"));
            out.writeObject(customers);
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving customers.");
        }
    }

    public void loadCustomers() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("customers.dat"));
            customers = (CustomerList) in.readObject();
            in.close();
        } catch (Exception e) {
            customers = new CustomerList();
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        new Bank();
    }
}
