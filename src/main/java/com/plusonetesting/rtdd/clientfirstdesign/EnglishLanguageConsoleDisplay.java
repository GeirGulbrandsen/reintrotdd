package com.plusonetesting.rtdd.clientfirstdesign;

public class EnglishLanguageConsoleDisplay implements Display {

    private static final String PRODUCT_NOT_FOUND_FOR_MESSAGE_FORMAT = "Product not found for %s";
    private static final String SCANNING_ERROR_EMPTY_BARCODE_MESSAGE_FORMAT = "Scanning error: empty barcode.";
    private static final String PRICE_IN_DOLLARS_MESSAGE_FORMAT = "$%,.2f";

    private void render(String text) {
        System.out.println(text);
    }

    private String mergeTemplate(String messageTemplate, Object... placeHolderValues) {
        return String.format(messageTemplate, placeHolderValues);
    }

    private void displayMessage(String messageTemplate, Object... placeHolderValues) {
        render(mergeTemplate(messageTemplate, placeHolderValues));
    }

    public void displayProductNotFoundMessage(String barcodeNotFound) {
        displayMessage(PRODUCT_NOT_FOUND_FOR_MESSAGE_FORMAT, barcodeNotFound);
    }

    public void displayEmptyBarcodeMessage() {
        displayMessage(SCANNING_ERROR_EMPTY_BARCODE_MESSAGE_FORMAT);
    }

    public void displayPrice(Price cents) {
        displayMessage(PRICE_IN_DOLLARS_MESSAGE_FORMAT, cents.dollarValue());
    }
}
