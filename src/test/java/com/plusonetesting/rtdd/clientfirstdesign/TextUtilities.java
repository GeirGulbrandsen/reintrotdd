package com.plusonetesting.rtdd.clientfirstdesign;

import java.util.Arrays;
import java.util.List;

public class TextUtilities {
    // REFACTOR Move this into a reusable library OR
    // find a library that implements this much more reliably.
    public static List<String> lines(String text) {
        return Arrays.asList(text.split(System.lineSeparator()));
    }
}
