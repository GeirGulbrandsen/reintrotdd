package com.plusonetesting.rtdd.clientfirstdesign;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.Assert.*;

public class VirtualPointOfSaleTerminalTest {

    private PrintStream productionStandardOut;

    @Before
    public void rememberStandardOut() {
        productionStandardOut = System.out;
    }

    @After
    public void restoreStandardOut() {
        System.setOut(productionStandardOut);
    }

    @Test
    public void testTheMainMethod() {
        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        VirtualPointOfSaleTerminal.main(new String[]{});

        assertEquals(
                Arrays.asList(
                        "$7.95",
                        "Product not found for 23345",
                        "Product not found for 99999",
                        "Scanning error: empty barcode."),
                TextUtilities.lines(canvas.toString(StandardCharsets.UTF_8)));
    }
}