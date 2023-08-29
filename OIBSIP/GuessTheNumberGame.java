import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ".");
        
        int attempts = 0;
        int userGuess;
        boolean hasGuessedCorrectly = false;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                hasGuessedCorrectly = true;
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry, you have exhausted all attempts. The correct number was: " + targetNumber);
        }
        
        scanner.close();
    }
}
