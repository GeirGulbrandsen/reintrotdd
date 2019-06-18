package com.plusonetesting.rtdd.pointofsale;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;


public class SellOneItemTest {

    private Display display;
    private Sale sale;

    @Before
    public void setUp() {
        display = new Display();
        sale = new Sale(new Catalog(new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
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

    public static class Catalog {
        private final Map<String, String> pricesByBarcode;

        public Catalog(Map<String, String> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public String findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }
}
