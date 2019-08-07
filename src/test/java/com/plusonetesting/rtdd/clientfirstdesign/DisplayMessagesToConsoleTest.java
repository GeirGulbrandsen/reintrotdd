package com.plusonetesting.rtdd.clientfirstdesign;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

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

        new EnglishLanguageConsoleDisplay().displayProductNotFoundMessage("12324545");

        Assert.assertEquals(
                Collections.singletonList("Product not found for 12324545"),
                TextUtilities.lines(canvas.toString(StandardCharsets.UTF_8))
        );
    }

    @Test
    public void emptyBarcodeMessage() {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        new EnglishLanguageConsoleDisplay().displayEmptyBarcodeMessage();
        Assert.assertEquals(
                Collections.singletonList("Scanning error: empty barcode."),
                TextUtilities.lines(canvas.toString(StandardCharsets.UTF_8))
        );
    }

    @Test
    public void multipleMessages() {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        EnglishLanguageConsoleDisplay consoleDisplay = new EnglishLanguageConsoleDisplay();
        consoleDisplay.displayProductNotFoundMessage("987234213");
        consoleDisplay.displayEmptyBarcodeMessage();
        consoleDisplay.displayProductNotFoundMessage("3459087");
        consoleDisplay.displayEmptyBarcodeMessage();

        Assert.assertEquals(
                Arrays.asList(
                        "Product not found for 987234213",
                        "Scanning error: empty barcode.",
                        "Product not found for 3459087",
                        "Scanning error: empty barcode."
                        ),
                TextUtilities.lines(canvas.toString(StandardCharsets.UTF_8))
        );
    }

}
