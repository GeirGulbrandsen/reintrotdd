package com.plusonetesting.rtdd.clientfirstdesign;

public class SaleController {
    private Catalog catalog;
    private Display display;

    public SaleController(Catalog catalog, Display display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        //SMELL Should I get an empty barcode at all? Ever?
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }

        Price price = catalog.findPrice(barcode);

        if (price == null)
            display.displayProductNotFoundMessage(barcode);
        else
            display.displayPrice(price);
    }
}
