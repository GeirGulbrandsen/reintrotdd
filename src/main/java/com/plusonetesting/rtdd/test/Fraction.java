package com.plusonetesting.rtdd.test;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int integerValue) {
        this.numerator = integerValue;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public Fraction plus(Fraction that) {
        return (new Fraction(this.numerator + that.numerator, denominator));
    }

    public int intValue() {
        return numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}
