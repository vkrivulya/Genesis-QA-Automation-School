package pages.thirdHomework;

import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number(non-negative integer): ");
        int a = sc.nextInt();
        int line;
        int hashSymbol;
        int row = 1;

        System.out.println("Triangle a");
        for (line = 1; line <= a; line++) {
            for (hashSymbol = 1; hashSymbol <= line; hashSymbol++) {
                System.out.print("# ");
            }
            System.out.println();
        }

        System.out.println("Triangle b");
        for (line = 1; line <= a; line++) {
            for (hashSymbol = 1; hashSymbol <= a; hashSymbol++) {
                if (line <= hashSymbol) System.out.print("# ");
            }
            System.out.println();
        }

        System.out.println("Triangle c");
        for (line = 0; line <= a; line++) {
            for (hashSymbol = 0; hashSymbol <= a; hashSymbol++) {
                if (line < hashSymbol) System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("Triangle d");

        for (line = 1; line <= a; line++) {
            for (hashSymbol = 1; hashSymbol <= a; hashSymbol++) {

                if (line > a - hashSymbol) System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("Triangle e");
        for (line = 1; line <= a; line++) {
            for (hashSymbol = 1; hashSymbol <= a; hashSymbol++) {
                if (line > a - hashSymbol) System.out.print("# ");
                else System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("Triangle f");
        for (line = 1; line <= a; line++) {
            for (hashSymbol = 1; hashSymbol <= a; hashSymbol++) {
                if (line <= hashSymbol) System.out.print("# ");
                else System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("Triangle a while loop");
        while (row <= a) {
            int col = 1;
            while (col <= row) {
                System.out.print("* ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
