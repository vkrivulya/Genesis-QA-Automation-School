package pages.homework4;

import java.util.Scanner;

public class FractionMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hello! Now let's check whether two Fraction objects represent the same fraction.");
        System.out.println("Enter first numerator(non-negative integer) for first Fraction: ");

        if (sc.hasNextInt()) {
            final int numerator = sc.nextInt();
            System.out.println("Enter denominator(non-negative integer) for first Fraction: ");
            final int denominator = sc.nextInt();
            double result = (double) numerator / denominator;
            System.out.println("Your first fraction: " + result);

            System.out.println("Enter numerator(non-negative integer) for second Fraction: ");
            final int numeratorSecond = sc.nextInt();
            System.out.println("Enter denominator(non-negative integer)for second Fraction: ");
            final int denominatorSecond = sc.nextInt();
            double resultSecond = (double) numeratorSecond / denominatorSecond;
            System.out.println("Your second fraction: " + resultSecond);

            Fraction fraction = new Fraction(numerator, denominator);
            Fraction fractionSecond = new Fraction(numeratorSecond, denominatorSecond);

            System.out.println("First fraction equals second fraction: " + fraction.equals(fractionSecond));
        } else {
            System.out.println("Sorry, that's not a number. Restart the program and try again!");
        }
    }
}
