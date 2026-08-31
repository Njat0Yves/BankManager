public class Bank {

    private Account[] accounts;
    private int accountCount;

    public Bank() {
        accounts = new Account[100];
        accountCount = 0;
    }

    public boolean addAccount(Account account) {
        if (accountCount < accounts.length) {
            accounts[accountCount] = account;
            accountCount++;
            return true;
        }

        return false;
    }

    public Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }

        return null;
    }

    public boolean transfer(String fromAccount, String toAccount, double amount) {
        Account source = findAccount(fromAccount);
        Account destination = findAccount(toAccount);

        if (source != null && destination != null) {
            if (source.withdraw(amount)) {
                destination.deposit(amount);
                return true;
            }
        }

        return false;
    }

    public void displayAllAccounts() {
        if (accountCount == 0) {
            System.out.println("Aucun compte bancaire.");
            return;
        }

        System.out.println("\n===== LISTE DES COMPTES =====");

        for (int i = 0; i < accountCount; i++) {
            System.out.println();
            accounts[i].displayInfo();
        }
    }
}