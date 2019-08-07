package com.plusonetesting.rtdd.clientfirstdesign;

import java.util.Map;

class InMemoryCatalog implements Catalog {
    private Map<String, Price> pricesByBarcode;

    public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public Price findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }
}
