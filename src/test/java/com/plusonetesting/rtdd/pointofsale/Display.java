package com.plusonetesting.rtdd.pointofsale;

public class Display {
    private String text;

    public String getText() {
        return text;
    }

    public void displayPrice(String priceAsText) {
        this.text = priceAsText;
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
}
