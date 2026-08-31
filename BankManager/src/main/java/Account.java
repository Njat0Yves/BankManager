public class Account {

    private String accountNumber;
    private String owner;
    private double balance;

    public Account(String accountNumber, String owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public void displayInfo() {
        System.out.println("Compte : " + accountNumber);
        System.out.println("Titulaire : " + owner);
        System.out.println("Solde : " + balance + " Ar");
    }
}
