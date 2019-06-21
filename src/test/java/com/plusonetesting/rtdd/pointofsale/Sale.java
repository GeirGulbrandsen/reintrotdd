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
//            REFACTOR Eventually a shopping cart?
            pendingPurchaseItemPrices.add(priceInCents);
            display.displayPrice(priceInCents);
        }
    }

    public void onTotal() {
        if (pendingPurchaseItemPrices.isEmpty()) {
            display.displayNoSaleInProgressMessage();
        } else {
            display.displayPurchaseTotal(pendingPurchaseTotal());
        }
    }
//REFACTOR Looks like Model behaviour to me
    private Integer pendingPurchaseTotal() {
        return computePurchaseTotal(pendingPurchaseItemPrices);
    }

    public static Integer computePurchaseTotal(Collection<Integer> purchaseItemPrices) {
        if (purchaseItemPrices.isEmpty()) {
            return 0;
        } else if (purchaseItemPrices.size() == 1) {
            return purchaseItemPrices.iterator().next();
        } else {
            return purchaseItemPrices.stream().reduce(0, Integer::sum);
        }
    }

}
