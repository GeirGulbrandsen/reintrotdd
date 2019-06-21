package com.plusonetesting.rtdd.pointofsale;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;


public class ScanOneItemTest {

    private Display display;
    private Sale sale;

    @Before
    public void setUp() {
        display = new Display();
        sale = new Sale(new Catalog(new HashMap<String, Integer>() {{
            put("12345", 795);
            put("23456", 1250);
        }}), display);
    }

    @Test
    public void productFound() {
        sale.onBarcode("12345");
        assertEquals("$7.95", display.getText());
    }

    @Test
    public void anotherProductFound() {
        sale.onBarcode("23456");
        assertEquals("$12.50", display.getText());
    }

    @Test
    public void productNotFound() {
        sale.onBarcode("99999");
        assertEquals("Product not found for 99999", display.getText());
    }

    @Test
    public void emptyBarcode() {
        sale.onBarcode("");
        assertEquals("Scanning error: empty barcode", display.getText());
    }

}
