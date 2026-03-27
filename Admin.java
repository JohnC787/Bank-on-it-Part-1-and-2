public class Admin extends User implements HasMenu {

    public Admin() {
        super("admin", "0000");
    }

    @Override
    public void menu() {
        System.out.println("\nAdmin Menu");
        System.out.println("0) Exit this menu");
        System.out.println("1) Full customer report");
        System.out.println("2) Add user");
        System.out.println("3) Apply interest to savings accounts");
        System.out.print("Action: ");
    }

    @Override
    public void start() {
        // Leave EMPTY as instructed
    }

    public String getReport() {
        return "Admin -> Username: " + getUserName() + ", PIN: " + getPIN();
    }
}
