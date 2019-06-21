package com.plusonetesting.rtdd.pointofsale;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class SellMultipleItemsTest {
    @Test
    public void zeroItems() {
        Display display = new Display();
        Sale sale = new Sale(null, display);

        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }

    @Test
    public void oneItemFound() {
        Catalog catalog = new Catalog(Collections.singletonMap("12345", 650));
        Display display = new Display();
        Sale sale = new Sale(catalog, display);
        sale.onBarcode("12345");

        sale.onTotal();

        assertEquals("Total: $6.50", display.getText());
    }

    @Test
    public void oneItemNotFound() {
        Display display = new Display();
        Catalog catalog = new Catalog(Collections.singletonMap("12345", 650));
        Sale sale = new Sale(catalog, display);

        sale.onBarcode("99999");
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }

    @Test
    public void severalItemsAllNotFound() {
        Display display = new Display();
        Sale sale = new Sale(
                catalogWithoutBarcodes(
                        "A product you won't find",
                        "Another product you won't find",
                        "A third product you won't find"),
                display);

        sale.onBarcode("A product you won't find");
        sale.onBarcode("Another product you won't find");
        sale.onBarcode("A third product you won't find");
        sale.onTotal();

        assertEquals("No sale in progress. Try scanning a product.", display.getText());
    }

    @Test
    public void severalItemsAllFound() {
        Display display = new Display();
        Catalog catalog = new Catalog(new HashMap<String, Integer>() {{
            put("1", 850);
            put("2", 1275);
            put("3", 330);
        }});
        Sale sale = new Sale(catalog, display);

        sale.onBarcode("1");
        sale.onBarcode("2");
        sale.onBarcode("3");
        sale.onTotal();

        assertEquals("Total: $24.55", display.getText());
    }

    private Catalog catalogWithoutBarcodes(String... barcodesToExclude) {
        return emptyCatalog();
    }

    private Catalog emptyCatalog() {
        return new Catalog(Collections.emptyMap());
    }
}
