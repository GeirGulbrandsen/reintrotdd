package com.plusonetesting.rtdd.pointofsale;

public class Sale {
    private Display display;
    private Catalog catalog;
    private String scannedPrice;

    public Sale(Catalog catalog, Display display) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }

        scannedPrice = catalog.findPrice(barcode);
        if (scannedPrice ==null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            display.displayPrice(scannedPrice);
        }
    }

    public void onTotal() {
        boolean saleInProgress = (scannedPrice != null);
        if (saleInProgress) {
            display.displayPurchaseTotal(scannedPrice);
        } else {
            display.displayNoSaleInProgressMessage();
        }
    }

}
