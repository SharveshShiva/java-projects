import java.util.Scanner;
import java.util.Random;

public class numberGuessingGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int guess;
        int attempts = 0;
        int randomNumber = random.nextInt(1,11);

        System.out.println("Number Guessing Game");
        System.out.print("Guess a number between 1-10: ");

        do{
            System.out.print("Enter a guess: ");
            guess = sc.nextInt();
            attempts++;

        }while(guess != randomNumber);

        System.out.println("You have won");
    }
}