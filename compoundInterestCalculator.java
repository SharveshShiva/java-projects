import java.util.Scanner;
public class compoundInterestCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double principal;
        double rate;
        int timesCompounded;
        int years;
        double amount;

        System.out.print("Enter the principal amount: ");
        principal = sc.nextDouble();

        System.out.print("Enter the interest rate (in %): ");
        rate = sc.nextDouble() / 100;

        System.out.print("Enter the no of times compounded per year: ");
        timesCompounded = sc.nextInt();

        System.out.print("Enter the no of years: ");
        years = sc.nextInt();


        amount = principal * Math.pow(1 + rate/timesCompounded, timesCompounded * years);

        System.out.println();

        System.out.printf("The amount after %d years is: $ %.2f", years, amount);

        sc.close();

    }
}