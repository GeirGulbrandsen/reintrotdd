package com.plusonetesting.rtdd.pointofsale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FormatMonetaryAmountTest {

    private final int priceInCents;
    private final String expectedFormattedPrice;

    public FormatMonetaryAmountTest(int priceInCents, String expectedFormattedPrice) {
        this.priceInCents = priceInCents;
        this.expectedFormattedPrice = expectedFormattedPrice;
    }

    @Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {520, "$5.20"}
        });
    }


    @Test
    public void test() {

        assertEquals(expectedFormattedPrice, format(priceInCents));
    }

    private static String format(int priceInCents) {
        return String.format("$%.2f", priceInCents / 100.0d);
    }
}
