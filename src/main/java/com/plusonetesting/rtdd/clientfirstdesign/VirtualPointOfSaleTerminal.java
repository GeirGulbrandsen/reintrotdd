package com.plusonetesting.rtdd.clientfirstdesign;

import java.util.HashMap;

public class VirtualPointOfSaleTerminal {
    public static void main(String[] args) {
        SaleController saleController = new SaleController(
                new InMemoryCatalog(new HashMap<String, Price>() {{
                    put("12345", Price.cents(795));
                    put("23456", Price.cents(1250));
                }}),
                new EnglishLanguageConsoleDisplay());

        saleController.onBarcode("12345");
        saleController.onBarcode("23345");
        saleController.onBarcode("99999");
        saleController.onBarcode("");
    }
}
