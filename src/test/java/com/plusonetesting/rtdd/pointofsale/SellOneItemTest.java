package com.plusonetesting.rtdd.pointofsale;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SellOneItemTest {
    @Test
    public void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }});

        sale.onBarcode("12345");
        assertEquals("$7.95", display.getText());
    }

    @Test
    public void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }});

        sale.onBarcode("23456");
        assertEquals("$12.50", display.getText());
    }

    @Test
    public void productNotFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }});

        sale.onBarcode("99999");
        assertEquals("Product not found for 99999", display.getText());
    }

    @Test
    public void emptyBarcode() {
        final Display display = new Display();
        final Sale sale = new Sale(display, new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("23456", "$12.50");
        }});

        sale.onBarcode("");
        assertEquals("Scanning error: empty barcode", display.getText());
    }

    public static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class Sale {
        private Display display;
        private Map<String, String> pricesByBarcode;

        public Sale(Display display, Map<String, String> pricesByBarcode) {
            this.display = display;
            this.pricesByBarcode = pricesByBarcode;
        }

        public void onBarcode(String barcode) {
            if ("".equals(barcode)) {
                display.setText("Scanning error: empty barcode");
                return;
            }

            if (pricesByBarcode.containsKey(barcode))
                display.setText(pricesByBarcode.get(barcode));
            else
                display.setText("Product not found for " + barcode);
        }
    }
}
