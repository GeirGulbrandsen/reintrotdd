package com.plusonetesting.rtdd.pointofsale;

public class Display {
    private String text;

    //    SMELL Move this behaviour somewhere else
        public static String format(int priceInCents) {
            return String.format("$%,.2f", priceInCents / 100.0d);
        }

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

    public void displayNoSaleInProgressMessage() {
        setText("No sale in progress. Try scanning a product.");
    }

    public void displayPurchaseTotal(String price) {
        this.text = "Total: " + price;
    }
}
