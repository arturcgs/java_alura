import java.util.Random;
import java.util.Scanner;

public class guessing_game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int answer = new Random().nextInt(100);
        int guess = 130;

        while (guess != answer) {
            System.out.println("Guess: ");
            guess = scanner.nextInt();

            if (guess > answer) {
                System.out.println("Guess lower!");
            } else {
                if (guess < answer) {
                    System.out.println("Guess higher!");
                }
            }

        }

        System.out.printf("You won! The answer was " + answer);


    }
}
