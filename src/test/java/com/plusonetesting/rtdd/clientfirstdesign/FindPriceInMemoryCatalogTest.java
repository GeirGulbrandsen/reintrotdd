package com.plusonetesting.rtdd.clientfirstdesign;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FindPriceInMemoryCatalogTest extends FindPriceInCatalogContract {

    @Override
    protected Catalog catalogWith(final String barcode, final Price price) {
        return new InMemoryCatalog(new HashMap<String, Price>() {{
            put("definitely not " + barcode, Price.cents(0));
            put(barcode, price);
            put("once again, definitely not " + barcode, Price.cents(100000000));
        }});
    }

    @Override
    protected Catalog catalogWithout(String barcodeToAvoid) {
        return new InMemoryCatalog((Collections.singletonMap(
                "anything but " + barcodeToAvoid, Price.cents(0)
        )));
    }
}
