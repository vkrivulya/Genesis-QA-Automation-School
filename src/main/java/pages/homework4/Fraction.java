package pages.homework4;

import java.util.Objects;

public class Fraction {

    private final int numerator;
    private final int denominator;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return divideNumbers() == fraction.divideNumbers();
    }

    private double divideNumbers() {
        return (double) numerator / denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    public Fraction(final int numerator, final int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
