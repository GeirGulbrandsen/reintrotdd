package com.plusonetesting.rtdd.clientfirstdesign;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DisplayPricesToConsoleTest {
    private PrintStream productionSystemOut;

    @Before
    public void rememberSystemOut() {
        productionSystemOut = System.out;
    }

    @After
    public void restoreSystemOut() {
        System.setOut(productionSystemOut);
    }

    private final int priceInCents;
    private final String expectedFormattedPrice;

    public DisplayPricesToConsoleTest(int priceInCents, String expectedFormattedPrice) {
        this.priceInCents = priceInCents;
        this.expectedFormattedPrice = expectedFormattedPrice;
    }

    @Parameters(name = "Monetary amount {0} formats to {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {789, "$7.89"},
                {520, "$5.20"},
                {400, "$4.00"},
                {0, "$0.00"},
                {2, "$0.02"},
                {37, "$0.37"},
                {418976, "$4,189.76"},
                {210832281, "$2,108,322.81"}
        });
    }

    @Test
    public void test() {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new EnglishLanguageConsoleDisplay().displayPrice(Price.cents(priceInCents));

        Assert.assertEquals(
                Collections.singletonList(expectedFormattedPrice),
                TextUtilities.lines(canvas.toString(StandardCharsets.UTF_8))
        );
    }
}

