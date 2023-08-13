import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random in = new Random();

        int lnum = 1;
        int unum = 100;
        int max_attempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game...!");

        while (true) {
            int generated_number = in.nextInt(unum - lnum + 1) + lnum;
            System.out.println("\nI have generated a number between " + lnum + " and " + unum);
            System.out.println("You have " + max_attempts + " attempts to guess the number");

            for (int a = 1; a <= max_attempts; a++) {
                System.out.print("Attempt " + a + ": Enter guess: ");
                int myguess = scanner.nextInt();

                if (myguess == generated_number) {
                    System.out.println("Congratulations! Your guess is correct!");
                    score += (max_attempts - a + 1);
                    break;
                } else if (myguess < generated_number) {
                    System.out.println("Your guess is low. Try again!");
                } else {
                    System.out.println("Your guess is high. Try again!");
                }

                if (a == max_attempts) {
                    System.out.println("Sorry, you have used all your attempts.The number was: " + generated_number);
                }
            }

            System.out.print("Do you want to play it again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Your final score: " + score);
        System.out.println("Thanks for playing..!");
        scanner.close();
    }
}