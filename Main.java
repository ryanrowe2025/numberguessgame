import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Initialize the user's highest score to a large number
        int highestScore = Integer.MAX_VALUE;

        // Play the game three times
        for (int i = 0; i < 3; i++) {
            // Prompt the user to enter the range of integers
            System.out.println("Enter the range of integers:");
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            // Generate a random number within the range
            Random random = new Random();
            int number = random.nextInt(end - start + 1) + start;

            // Create an ArrayList to store past guesses
            ArrayList<Integer> pastGuesses = new ArrayList<>();

            // Initialize the number of guesses to 0
            int numGuesses = 0;

            // Loop until the user guesses the correct number
            while (true) {
                // Prompt the user to enter a guess
                System.out.println("Enter a guess:");
                int guess = scanner.nextInt();

                // Check if the user has already guessed this number
                if (pastGuesses.contains(guess)) {
                    System.out.println("You have already guessed this number. Try again.");
                    continue;
                }

                // Add the guess to the ArrayList of past guesses
                pastGuesses.add(guess);

                // Increment the number of guesses
                numGuesses++;

                // Check if the guess is correct
                if (guess == number) {
                    System.out.println("You guessed the correct number in " + numGuesses + " guesses!");
                    break;
                } else if (guess < number) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            // Update the user's highest score
            highestScore = Math.min(highestScore, numGuesses);
        }

        // Print the user's highest score
        System.out.println("Your highest score is " + highestScore + " guesses.");
    }
}
