package com.plusonetesting.rtdd.clientfirstdesign;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FindPriceInMemoryCatalogTest {

    @Test
    public void productFound() {
        Price foundPrice = Price.cents(1250);

        InMemoryCatalog catalog = new InMemoryCatalog(Collections.singletonMap("12345", foundPrice));
        assertEquals(foundPrice, catalog.findPrice("12345"));
    }

    private class InMemoryCatalog {
        private Map<String, Price> pricesByBarcode;

        public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
            this.pricesByBarcode = pricesByBarcode;
        }

        public Price findPrice(String barcode) {
            return pricesByBarcode.get(barcode);
        }
    }

    @Test
    public void productNotFound() {

        InMemoryCatalog catalog = new InMemoryCatalog((Collections.emptyMap()));
        assertEquals(null, catalog.findPrice("12345"));

    }
}
