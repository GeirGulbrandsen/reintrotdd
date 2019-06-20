package com.plusonetesting.rtdd.pointofsale;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatMonetaryAmountTest {

    @Test
    public void simplest() {

        assertEquals("$7.89", format(789));
    }

    private static String format(int priceInCents) {
        return "$7.89";
    }
}
