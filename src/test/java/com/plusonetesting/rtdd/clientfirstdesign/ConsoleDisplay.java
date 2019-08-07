package com.plusonetesting.rtdd.clientfirstdesign;

public class ConsoleDisplay {

    public static String formatPrice(Price cents) {
        return String.format("$%,.2f", cents.dollarValue());
    }

    public void displayProductNotFoundMessage(String barcodeNotFound) {
        System.out.println(String.format("Product not found for %s", barcodeNotFound));
    }

    public void displayEmptyBarcodeMessage() {
        System.out.println("Scanning error: empty barcode.");
    }

    public void displayPrice(Price cents) {
        System.out.println(formatPrice(cents));
    }
}
