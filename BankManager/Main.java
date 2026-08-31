import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        boolean running = true;

        while (running) {

            System.out.println("\n===== BANK MANAGER =====");
            System.out.println("1. Créer un compte");
            System.out.println("2. Déposer de l'argent");
            System.out.println("3. Retirer de l'argent");
            System.out.println("4. Consulter un compte");
            System.out.println("5. Transférer de l'argent");
            System.out.println("6. Afficher tous les comptes");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Numéro du compte : ");
                    String number = scanner.nextLine();

                    System.out.print("Nom du titulaire : ");
                    String owner = scanner.nextLine();

                    System.out.print("Solde initial : ");
                    double initialBalance = scanner.nextDouble();

                    Account newAccount =
                            new Account(number, owner, initialBalance);

                    if (bank.addAccount(newAccount)) {
                        System.out.println("Compte créé avec succès !");
                    } else {
                        System.out.println("Impossible de créer le compte.");
                    }
                    break;

                case 2:
                    System.out.print("Numéro du compte : ");
                    String depositNumber = scanner.nextLine();

                    Account depositAccount =
                            bank.findAccount(depositNumber);

                    if (depositAccount != null) {
                        System.out.print("Montant à déposer : ");
                        double amount = scanner.nextDouble();

                        depositAccount.deposit(amount);
                        System.out.println("Dépôt effectué avec succès !");
                    } else {
                        System.out.println("Compte introuvable.");
                    }
                    break;

                case 3:
                    System.out.print("Numéro du compte : ");
                    String withdrawNumber = scanner.nextLine();

                    Account withdrawAccount =
                            bank.findAccount(withdrawNumber);

                    if (withdrawAccount != null) {
                        System.out.print("Montant à retirer : ");
                        double amount = scanner.nextDouble();

                        if (withdrawAccount.withdraw(amount)) {
                            System.out.println("Retrait effectué avec succès !");
                        } else {
                            System.out.println(
                                    "Retrait impossible : solde insuffisant ou montant invalide."
                            );
                        }
                    } else {
                        System.out.println("Compte introuvable.");
                    }
                    break;

                case 4:
                    System.out.print("Numéro du compte : ");
                    String accountNumber = scanner.nextLine();

                    Account account = bank.findAccount(accountNumber);

                    if (account != null) {
                        System.out.println();
                        account.displayInfo();
                    } else {
                        System.out.println("Compte introuvable.");
                    }
                    break;

                case 5:
                    System.out.print("Compte source : ");
                    String source = scanner.nextLine();

                    System.out.print("Compte destination : ");
                    String destination = scanner.nextLine();

                    System.out.print("Montant à transférer : ");
                    double transferAmount = scanner.nextDouble();

                    if (bank.transfer(source, destination, transferAmount)) {
                        System.out.println("Transfert effectué avec succès !");
                    } else {
                        System.out.println("Transfert impossible.");
                    }
                    break;

                case 6:
                    bank.displayAllAccounts();
                    break;

                case 0:
                    running = false;
                    System.out.println("Merci d'avoir utilisé Bank Manager !");
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}