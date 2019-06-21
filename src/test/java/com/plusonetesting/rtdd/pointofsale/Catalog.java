package com.plusonetesting.rtdd.pointofsale;

import java.util.Map;

public class Catalog {
    private Map<String, String> pricesAsTextByBarcode;
    private Map<String, Integer> pricesInCentsByBarcode;

    public Catalog(Map<String, String> pricesAsTextByBarcode, Map<String, Integer> pricesInCentsByBarcode) {
        this.pricesAsTextByBarcode = pricesAsTextByBarcode;
        this.pricesInCentsByBarcode = pricesInCentsByBarcode;
    }

//    SMELL Move this behaviour somewhere else
    public static String format(int priceInCents) {
        return String.format("$%,.2f", priceInCents / 100.0d);
    }

    public String findPriceThenFormatPrice(String barcode) {
        Integer priceInCents = pricesInCentsByBarcode.get(barcode);

        if (priceInCents == null) {
            return null;
        } else {
            return format(priceInCents);
        }
    }
}
