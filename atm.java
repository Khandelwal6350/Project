
import java.util.Scanner;

public class atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        user user = new user();

        user.register();

        if (user.verifyPin()) {
            int choice;
            do {
                System.out.println("\nATM MENU:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        user.getBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double dep = sc.nextDouble();
                        user.deposit(dep);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        double with = sc.nextDouble();
                        user.withdraw(with);
                        break;
                    case 4:
                        System.out.println("Thank you! Visit again.");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        sc.close();
    }
}
