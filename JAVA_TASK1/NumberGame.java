import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static int totalGames = 0;
    private static int gamesWon = 0;
    private static int highScore = 0;

    public static void main(String[] args) {
        printWelcome();

        do {
            playRound();
            printStats();
        } while (askToPlayAgain());

        System.out.println("\nThanks for playing. See you next time!");
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("==============================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("==============================");
        System.out.println("Guess the secret number from " + MIN_NUMBER + " to " + MAX_NUMBER + ".");
    }

    private static void playRound() {
        totalGames++;

        Difficulty difficulty = chooseDifficulty();
        int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attemptsUsed = 0;
        boolean won = false;

        System.out.println("\nDifficulty: " + difficulty.name);
        System.out.println("You have " + difficulty.maxAttempts + " attempts.");

        while (attemptsUsed < difficulty.maxAttempts) {
            int guess = readGuess();
            attemptsUsed++;

            if (guess == secretNumber) {
                won = true;
                gamesWon++;

                int score = calculateScore(difficulty.maxAttempts, attemptsUsed);
                updateHighScore(score);

                System.out.println("\nCorrect! You found it in " + attemptsUsed + " attempt(s).");
                System.out.println("Score earned: " + score);
                break;
            }

            printGuessFeedback(guess, secretNumber);
            printHintIfAvailable(secretNumber, attemptsUsed);

            int attemptsLeft = difficulty.maxAttempts - attemptsUsed;
            if (attemptsLeft > 0) {
                System.out.println("Attempts left: " + attemptsLeft);
            }
        }

        if (!won) {
            System.out.println("\nYou lost this round.");
            System.out.println("The correct number was: " + secretNumber);
        }
    }

    private static Difficulty chooseDifficulty() {
        System.out.println("\nSelect Difficulty:");
        System.out.println("1. Easy   - 10 attempts");
        System.out.println("2. Medium - 7 attempts");
        System.out.println("3. Hard   - 5 attempts");

        while (true) {
            int choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    return new Difficulty("Easy", 10);
                case 2:
                    return new Difficulty("Medium", 7);
                case 3:
                    return new Difficulty("Hard", 5);
                default:
                    System.out.println("Please choose 1, 2, or 3.");
            }
        }
    }

    private static int readGuess() {
        while (true) {
            int guess = readInt("\nEnter your guess: ");

            if (guess >= MIN_NUMBER && guess <= MAX_NUMBER) {
                return guess;
            }

            System.out.println("Your guess must be between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid whole number.");
                scanner.next();
            }
        }
    }

    private static void printGuessFeedback(int guess, int secretNumber) {
        if (guess < secretNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
    }

    private static void printHintIfAvailable(int secretNumber, int attemptsUsed) {
        if (attemptsUsed == 3) {
            String parity = secretNumber % 2 == 0 ? "even" : "odd";
            System.out.println("Hint: The number is " + parity + ".");
        }
    }

    private static int calculateScore(int maxAttempts, int attemptsUsed) {
        return (maxAttempts - attemptsUsed + 1) * 10;
    }

    private static void updateHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            System.out.println("New high score!");
        }
    }

    private static void printStats() {
        int gamesLost = totalGames - gamesWon;
        double winRate = ((double) gamesWon / totalGames) * 100;

        System.out.println("\n========== GAME STATS ==========");
        System.out.println("Games played : " + totalGames);
        System.out.println("Games won    : " + gamesWon);
        System.out.println("Games lost   : " + gamesLost);
        System.out.println("High score   : " + highScore);
        System.out.printf("Win rate     : %.2f%%%n", winRate);
        System.out.println("Rating       : " + getRating(winRate));
    }

    private static String getRating(double winRate) {
        if (winRate >= 80) {
            return "Expert";
        }

        if (winRate >= 50) {
            return "Intermediate";
        }

        return "Beginner";
    }

    private static boolean askToPlayAgain() {
        System.out.print("\nPlay again? (Y/N): ");
        char answer = scanner.next().trim().toLowerCase().charAt(0);
        return answer == 'y';
    }

    private static class Difficulty {
        private final String name;
        private final int maxAttempts;

        private Difficulty(String name, int maxAttempts) {
            this.name = name;
            this.maxAttempts = maxAttempts;
        }
    }
}