import java.util.Scanner;
import java.util.Random;

class Game {
    int rounds = 5;

    void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userScore = 0;
        int computerScore = 0;

        System.out.println("Welcome to Stone Paper Scissors!");
        System.out.println("Choices: 0 = Stone, 1 = Paper, 2 = Scissors");

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i + ":");
            System.out.print("Enter your choice: ");
            int userChoice = scanner.nextInt();

            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid choice! Try again.");
                i--; 
                continue;
            }

            int computerChoice = random.nextInt(3);

            String[] choices = {"Stone", "Paper", "Scissors"};
            System.out.println("You chose: " + choices[userChoice]);
            System.out.println("Computer chose: " + choices[computerChoice]);

            if (userChoice == computerChoice) {
                System.out.println("It's a Tie!");
            } else if ((userChoice == 0 && computerChoice == 2) ||
                    (userChoice == 1 && computerChoice == 0) ||
                    (userChoice == 2 && computerChoice == 1)) {
                System.out.println("You Win this round!");
                userScore++;
            } else {
                System.out.println("Computer Wins this round!");
                computerScore++;
            }
        }

        System.out.println("\n--- Game Over ---");
        System.out.println("Your Score: " + userScore);
        System.out.println("Computer Score: " + computerScore);

        if (userScore > computerScore) {
            System.out.println("🎉 Congratulations! You won the game!");
        } else if (userScore < computerScore) {
            System.out.println("😞 Sorry! Computer won the game.");
        } else {
            System.out.println("😐 It's a tie game!");
        }

        scanner.close();
    }
}

public class game2 {
    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}
