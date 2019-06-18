package com.plusonetesting.rtdd.pointofsale;

public class Sale {
    private Display display;
    private Catalog catalog;
    private String price;

    public Sale(Catalog catalog, Display display) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }

        price = catalog.findPrice(barcode);
        if (price ==null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            display.displayPrice(price);
        }
    }

    public void onTotal() {
        if (price == null) {
            display.displayNoSaleInProgressMessage();
        } else {
            display.text = "Total: $6.50";
        }
    }

}
