package com.plusonetesting.rtdd.addfractions;

import org.junit.Test;

import static com.plusonetesting.rtdd.addfractions.NumberTheory.gcd;
import static org.junit.Assert.*;

public class NumberTheoryTest {

    @Test
    public void gcdTest() {
        assertEquals(gcd(2, 6), 2);
    }
}