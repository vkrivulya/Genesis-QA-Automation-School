package pages.secondHomework;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverterMainPage {

    private static final double COMMISSION = 1;
    private static final double EXCHANGE_RATE = 36.55;

    public static void main(String[] args) {

        CurrencyConverter currencyConverter = new CurrencyConverter(COMMISSION, EXCHANGE_RATE);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount in dollar:");
        if (sc.hasNextFloat()) {
            final double amountInUsd = sc.nextFloat();
            final double amountInUah = currencyConverter.convertUsdToUah(amountInUsd);
            final double commissionInUah = currencyConverter.calculateCommission(amountInUah);
            final double amountToBePaid = currencyConverter.calculateTotalAmount(amountInUah, commissionInUah);

            System.out.println(amountInUsd + " USD is equivalent to " + decimalFormat.format(amountInUah) + " UAH.");
            System.out.println("Commission = " + decimalFormat.format(commissionInUah) + " UAH");
            System.out.println("Total amount to be paid = " + decimalFormat.format(amountToBePaid) + " UAH");

        } else {
            System.out.println("Sorry, that's not a number. Restart the program and try again!");
        }
    }
}
