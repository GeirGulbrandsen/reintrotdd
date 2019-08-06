package com.plusonetesting.rtdd.clientfirstdesign;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class DisplayMessagesToConsoleTest {

    private PrintStream productionSystemOut;

    @Before
    public void rememberSystemOut() {
        productionSystemOut = System.out;
    }

    @After
    public void restoreSystemOut() {
        System.setOut(productionSystemOut);
    }

    @Test
    public void productNotFoundMessage() {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new ConsoleDisplay().displayProductNotFoundMessage("12324545");

        Assert.assertEquals(
                Arrays.asList("Product not found for 12324545"),
                TextUtilities.lines(canvas.toString(StandardCharsets.UTF_8))
        );
    }

    public static class ConsoleDisplay {

        public void displayProductNotFoundMessage(String barcodeNotFound) {
            System.out.println(String.format("Product not found for %s", barcodeNotFound));
        }
    }
}
