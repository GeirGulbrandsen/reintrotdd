package com.plusonetesting.rtdd.test;

public class Fraction {

    private int numerator;
    private int denominator;
    private int integerValue;

    public Fraction(int integerValue) {
        this.integerValue = integerValue;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.integerValue = numerator;
        this.denominator = denominator;
    }


    public Fraction plus(Fraction that) {
        return (new Fraction(this.integerValue + that.integerValue, denominator));
    }

    public int intValue() {
        return integerValue;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
