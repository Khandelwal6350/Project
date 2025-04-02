
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userGuess;
        int targetNumber = 15;
        int maxAttempts = 5;

        System.out.println("Guess the number between 1 to 100.");
        System.out.println("You have a maximum of " + maxAttempts + " attempts.");

        for (int i = 0; i < maxAttempts; i++) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            } else if (userGuess > targetNumber) {
                System.out.println("Your guess is too high! Try a smaller number.");
            } else {
                System.out.println("Your guess is too low! Try a larger number.");
            }

            if (i == maxAttempts - 1) {
                System.out.println("Sorry! You've exhausted all attempts. The correct number was " + targetNumber);
            }
        }

        sc.close();
    }

}


