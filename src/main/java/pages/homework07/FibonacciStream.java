package pages.homework07;

import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciStream {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Fibonacci number at index:");

        if (sc.hasNextLong()) {
            final int n = sc.nextInt();
            long fibonacciNumber = calculateFibonacci(n);
            System.out.println("Fibonacci number at index " + n + ": " + fibonacciNumber);
        } else {
            System.out.println("Sorry, that's not a number. Restart the program and try again!");
        }
    }

    public static long calculateFibonacci(int n) {
        return Stream.iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
                .limit(n)
                .reduce((first, second) -> second)
                .orElseThrow(() -> new IllegalArgumentException("Invalid index: " + n))[0];
    }
}
