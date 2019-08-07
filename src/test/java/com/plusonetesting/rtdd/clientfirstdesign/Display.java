package com.plusonetesting.rtdd.clientfirstdesign;

public interface Display {
    void displayPrice(Price price);

    void displayProductNotFoundMessage(String barcodeNotFound);

    void displayEmptyBarcodeMessage();
}
