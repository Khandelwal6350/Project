import java.util.Random;
import java.util.Scanner;

public class cricketgame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int balls = 6;
        int score = 0;
        boolean isOut = false;

        System.out.println("🏏 Welcome to One Over Cricket!");
        System.out.println("Rules:");
        System.out.println("Enter a number between 1 and 6 as your shot.");
        System.out.println("- If your number matches the bowler's, you're OUT!");
        System.out.println("- Score as many runs as possible in 6 balls.\n");

        for (int ball = 1; ball <= balls; ball++) {
            System.out.print("Ball " + ball + " - Enter your run (1-6): ");
            int userShot = scanner.nextInt();

            if (userShot < 1 || userShot > 6) {
                System.out.println("Invalid input! Try again.");
                ball--; // Retry same ball
                continue;
            }

            int computerBall = random.nextInt(6) + 1;

            System.out.println("Bowler bowled: " + computerBall);

            if (userShot == computerBall) {
                System.out.println("💥 You're OUT!");
                isOut = true;
                break;
            } else {
                score += userShot;
                System.out.println("✅ Runs Scored: " + userShot + " | Total: " + score + "\n");
            }
        }

        System.out.println("\n--- Game Over ---");
        System.out.println("🏆 Final Score: " + score);
        if (isOut) {
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Well played! Great batting!");
        }

        scanner.close();
    }
}
