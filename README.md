
## Program Algorithm

1. **Start Program**

   * Create a default `Customer` object
   * Initialize:

     * Username = "Alice"
     * PIN = "0000"
     * Checking and Savings accounts with $0 balance

2. **User Login**

   * Prompt user to enter username
   * Prompt user to enter PIN
   * If credentials match:

     * Display "Login Successful"
   * Else:

     * Display "Login Failed"
     * End program

3. **Display Customer Menu**

   * Show options:

     * 0 → Exit
     * 1 → Manage Checking Account
     * 2 → Manage Savings Account
     * 3 → Change PIN

4. **Process Customer Choice**

   * If user selects:

   ### Option 1: Checking Account

   * Display account menu:

     * 0 → Quit
     * 1 → Check balance
     * 2 → Deposit
     * 3 → Withdraw
   * Repeat until user selects 0:

     * If 1 → Display current balance
     * If 2 → Ask for deposit amount → Add to balance
     * If 3 → Ask for withdrawal amount → Subtract from balance

   ### Option 2: Savings Account

   * Display account menu (same as checking)
   * Repeat until user selects 0:

     * If 1 → Display current balance
     * If 2 → Deposit money
     * If 3 → Withdraw money

   ### Option 3: Change PIN

   * Prompt user for new PIN
   * Update stored PIN
   * Display confirmation message

   ### Option 0: Exit

   * End program

5. **Loop**

   * Return to Customer Menu after each action
   * Continue until user selects Exit

6. **End Program**

---

## Key Features

* Menu-driven interface
* Separate checking and savings accounts
* Deposit and withdrawal functionality
* Secure login system
* PIN change capability

---

## Future Improvements

* Add admin user functionality
* Support multiple customers
* Implement file saving/loading (persistence)
* Add interest calculation for savings accounts
