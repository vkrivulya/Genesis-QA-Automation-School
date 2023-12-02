package pages.secondHomework;

public class CurrencyConverter {

    private final double commission;
    private final double exchangeRate;

    public CurrencyConverter(final double commission, final double exchangeRate) {
        this.commission = commission;
        this.exchangeRate = exchangeRate;
    }

    public double convertUsdToUah(final double amount) {
        return amount * exchangeRate;
    }

    public double calculateCommission(final double amount) {
        return (commission / 100) * amount;
    }

    public double calculateTotalAmount(final double amountUah, final double commissionInUah) {
        return amountUah - commissionInUah;
    }

}
