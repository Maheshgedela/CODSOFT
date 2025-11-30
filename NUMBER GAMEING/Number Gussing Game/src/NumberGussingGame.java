

import java.util.*;

public class NumberGussingGame {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            int totalScore = 0; // score for all rounds

            System.out.println("===== Number Guessing Game =====");

            while (true) {

                int numberToGuess = random.nextInt(100) + 1; // 1-100
                int attempts = 0;
                int maxAttempts = 7;   // limit attempts
                boolean guessedCorrectly = false;

                System.out.println("\nNew Round Started!");
                System.out.println("Guess the number between 1 and 100");
                System.out.println("You have " + maxAttempts + " attempts.");

                while (attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = sc.nextInt();
                    attempts++;

                    if (userGuess == numberToGuess) {
                        System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                        totalScore += (maxAttempts - attempts + 1); // more attempts left = more score
                        guessedCorrectly = true;
                        break;
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
                }

                System.out.println("Your total score: " + totalScore);

                // ask user if they want to play again
                System.out.print("Do you want to play another round? (yes/no): ");
                String choice = sc.next().toLowerCase();

                if (!choice.equals("yes")) {
                    System.out.println("\nThanks for playing! Your final score: " + totalScore);
                    break;
                }
            }

            sc.close();
        }
    }


