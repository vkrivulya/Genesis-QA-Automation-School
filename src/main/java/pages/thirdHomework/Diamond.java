package pages.thirdHomework;

import java.util.Scanner;

public class Diamond {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number(non-negative integer): ");
        int a = sc.nextInt();
        int line;
        int hashSymbol;
        int count = 1;

        System.out.println("Diamond: ");
        for (line = 1; line <= 2 * a - 1; line++) {
            for (hashSymbol = count; hashSymbol <= a; hashSymbol++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= count * 2 - 1; k++) {
                System.out.print("* ");
            }
            if (line < a)
                count++;
            else
                count--;
            System.out.println("");
        }
    }
}
