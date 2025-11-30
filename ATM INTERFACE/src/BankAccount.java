
import java.util.*;
public class BankAccount {


        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // Deposit method
        public void deposit(double amount) {
            balance += amount;
        }

        // Withdraw method (with validation)
        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true; // success
            }
            return false; // insufficient balance
        }

        // Check balance
        public double getBalance() {
            return balance;
        }
    }

    // ATM class (acts as interface)
    class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        // Display menu options
        public void showMenu() {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
        }

        // Check balance method
        public void checkBalance() {
            System.out.println("Your balance is: ₹" + account.getBalance());
        }

        // Deposit method
        public void deposit(double amount) {
            if (amount > 0) {
                account.deposit(amount);
                System.out.println("₹" + amount + " deposited successfully.");
            } else {
                System.out.println("Invalid amount! Please enter a positive number.");
            }
        }

        // Withdraw method
        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount! Enter a positive value.");
            } else if (account.withdraw(amount)) {
                System.out.println("₹" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance!");
            }
        }
    }



