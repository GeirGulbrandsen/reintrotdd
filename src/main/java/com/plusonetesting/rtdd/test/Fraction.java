package com.plusonetesting.rtdd.test;

public class Fraction{

    private int integerValue;

    public Fraction(int integerValue) {
        this.integerValue = integerValue;
    }

    public Fraction plus(Fraction that) {
        return this;
    }

    public int intValue() {
        return integerValue;
    }
}
