package com.plusonetesting.rtdd.pointofsale;

public class Sale {
    private Display display;
    private SellOneItemTest.Catalog catalog;

    public Sale(Display display, SellOneItemTest.Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }

        final String priceAsText = catalog.findPrice(barcode);
        if (priceAsText==null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            display.displayPrice(priceAsText);
        }
    }

    public void onTotal() {
        display.setText("No sale in progress. Try scanning a product.");
    }
}
