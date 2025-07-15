import java.util.Scanner;

class BankAccount {
    double balance;

    BankAccount(double initialBal) {
        balance = initialBal;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    double getBalance() {
        return balance;
    }
}

class ATM {
    BankAccount account;

    ATM(BankAccount acc) {
        account = acc;
    }

    void start() {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Balance: " + account.getBalance());
            } else if (choice == 2) {
                System.out.print("Enter amount to deposit: ");
                double amt = sc.nextDouble();
                account.deposit(amt);
                System.out.println("Amount deposited.");
            } else if (choice == 3) {
                System.out.print("Enter amount to withdraw: ");
                double amt = sc.nextDouble();
                if (account.withdraw(amt)) {
                    System.out.println("Amount withdrawn.");
                } else {
                    System.out.println("Insufficient balance or invalid amount.");
                }
            } else if (choice == 4) {
                System.out.println("Thank you! Exiting...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}

public class ATM_Mechine {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(500);  // Initial balance
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
