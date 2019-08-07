package com.plusonetesting.rtdd.clientfirstdesign;

public class Price {
    private final int centsValue;

    public Price(int centsValue) {
        this.centsValue = centsValue;
    }

    public static Price cents(int centsValues) {
        return new Price(centsValues);
    }

    public double dollarValue() {
        return centsValue/100.0d;
    }

    @Override
    public String toString() {
        return "a Price";
    }
}
