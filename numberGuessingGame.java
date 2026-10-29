import java.util.Scanner;
import java.util.Random;

public class numberGuessingGame{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int guess;
        int attempts = 0;
        int randomNumber = random.nextInt(1,101);

        System.out.println("Number Guessing Game");
        System.out.println("Guess a number between 1-100: ");

        do{
            System.out.print("Enter a guess: ");
            guess = sc.nextInt();
            attempts++;

            if(guess < randomNumber){
                System.out.println("TOO LOW! Try again");
            }
            else if(guess > randomNumber){
                System.out.println("TOO HIGH! Try again");
            }
            else{
                System.out.println("CORRECT! The number was " + randomNumber);
                System.out.println("# of attempts: " + attempts);
            }

        }while(guess != randomNumber);

        System.out.println("You have won");
    }
}