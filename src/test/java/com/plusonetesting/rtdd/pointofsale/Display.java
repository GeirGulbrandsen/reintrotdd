package com.plusonetesting.rtdd.pointofsale;

public class Display {
    private String text;

    public static String formatMonetaryAmount(int priceInCents) {
        return String.format("$%,.2f", priceInCents / 100.0d);
    }

    public String getText() {
        return text;
    }

    public void displayProductNotFoundMessage(String barcode) {
        this.text = "Product not found for " + barcode;
    }

    public void displayEmptyBarcodeMessage() {
        this.text = "Scanning error: empty barcode";
    }

    public void setText(String thatText) {
        this.text = thatText;
    }

    public void displayNoSaleInProgressMessage() {
        setText("No sale in progress. Try scanning a product.");
    }

    public void displayPurchaseTotal(Integer purchaseTotal) {
        this.text = "Total: " + formatMonetaryAmount(purchaseTotal);
    }

    public void displayPrice(Integer priceInCents) {
        this.text = formatMonetaryAmount(priceInCents);
    }
}
