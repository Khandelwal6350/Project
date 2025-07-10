
import java.util.Scanner;

public class user {
    Scanner sc = new Scanner(System.in);

    String name;
    int pin;
    String mobileNumber;
    double balance = 1.0;

    // Register user
    public void register() {
        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter your mobile number: ");
        mobileNumber = sc.nextLine();

        System.out.print("Set your PIN (4 digits): ");
        pin = sc.nextInt();

        System.out.println("User registered successfully!");
    }

    public void setPin() {
        System.out.print("Enter your new PIN: ");
        pin = sc.nextInt();
        System.out.println("PIN updated successfully.");
    }


    public boolean verifyPin() {
        System.out.print("Enter your PIN to continue: ");
        int enteredPin = sc.nextInt();
        return enteredPin == pin;
    }


    public void getBalance() {
        System.out.println("Current balance is: ₹" + balance);
    }


    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;//balance=balance+account
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }


    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
