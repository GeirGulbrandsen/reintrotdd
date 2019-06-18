package com.plusonetesting.rtdd.pointofsale;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SellMultipleItemsTest {

    @Test
    public void zeroItems() {
        Display display = new Display();
        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }
}
