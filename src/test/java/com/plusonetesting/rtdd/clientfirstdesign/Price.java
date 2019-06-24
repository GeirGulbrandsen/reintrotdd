package com.plusonetesting.rtdd.clientfirstdesign;

public class Price {
    public static Price cents(int centsValues) {
        return new Price();
    }

    @Override
    public String toString() {
        return "a Price";
    }
}
