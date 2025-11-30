
import java.util.*;

public class ATMInterface {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount userAccount = new BankAccount(5000); // initial balance
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.showMenu();
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}


