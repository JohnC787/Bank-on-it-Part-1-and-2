public class Admin extends User implements HasMenu {

    public Admin() {
        setUserName("admin");
        setPIN("0000");
    }
    @Override
    public String menu() {
        return "\nAdmin Menu\n" +
               "0) Exit this menu\n" +
               "1) Full customer report\n" +
               "2) Add user\n" +
               "3) Apply interest to savings accounts\n";
    }

    @Override
    public void start() {
        // Leave EMPTY as instructed
    }

    public String getReport() {
        return "Admin -> Username: " + getUserName() + ", PIN: " + getPIN();
    }
}
