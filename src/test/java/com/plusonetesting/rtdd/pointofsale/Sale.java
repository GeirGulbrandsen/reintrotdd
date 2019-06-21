package com.plusonetesting.rtdd.pointofsale;

import java.util.ArrayList;
import java.util.Collection;

public class Sale {
    private Display display;
    private Catalog catalog;
    private Collection<Integer> pendingPurchaseItemPrices = new ArrayList<>();

    public Sale(Catalog catalog, Display display) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;
        }

        Integer priceInCents = catalog.findPrice(barcode);
        if (priceInCents == null) {
            display.displayProductNotFoundMessage(barcode);
        } else {
            pendingPurchaseItemPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        boolean saleInProgress = (!pendingPurchaseItemPrices.isEmpty());
        if (saleInProgress) {
            display.displayPurchaseTotal(Display.format(pendingPurchaseItemPrices.iterator().next()));
        } else {
            display.displayNoSaleInProgressMessage();
        }
    }

}
