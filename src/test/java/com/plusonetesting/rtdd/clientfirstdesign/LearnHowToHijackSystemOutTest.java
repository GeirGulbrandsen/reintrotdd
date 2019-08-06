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
import java.util.List;

public class LearnHowToHijackSystemOutTest {

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
    public void singleLineOfText() {

        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        System.out.println("Hello, world.");

        Assert.assertEquals(
                Collections.singletonList("Hello, world."),
                lines(canvas.toString(StandardCharsets.UTF_8)));
    }

    @Test
    public void severalLinesOfText() {

        ByteArrayOutputStream canvas = new ByteArrayOutputStream();
        System.setOut(new PrintStream(canvas));

        for (int i = 1; i <= 5; i++) {
            System.out.println("Line " + i);
        }

        Assert.assertEquals(
                Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4", "Line 5"),
                lines(canvas.toString(StandardCharsets.UTF_8)));
    }

    // REFACTOR Move this into a reusable library OR
    // find a library that implements this much more reliably.
    private static List<String> lines(String text) {
        return Arrays.asList(text.split(System.lineSeparator()));
    }


}
