package com.plusonetesting.rtdd.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddFractionTest {

    @Test
    public void zeroPlusZeroShouldBeZero() {

        Fraction sum = new Fraction(0).plus(new Fraction(0));
        assertThat(sum.intValue() ,is(0));
    }
}
