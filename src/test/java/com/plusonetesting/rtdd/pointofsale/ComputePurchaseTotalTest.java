package com.plusonetesting.rtdd.pointofsale;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComputePurchaseTotalTest {
    @Test
    public void zeroItems() {
        assertEquals(0, computePurchaseTotal(Collections.emptyList()));
    }

    @Test
    public void oneItem() {
        assertEquals(795, computePurchaseTotal(Collections.singletonList(795)));
    }

    @Test
    public void severalItems() {
        assertEquals(2450, computePurchaseTotal(Arrays.asList(850, 1275, 325)));
    }

    private int computePurchaseTotal(List<Integer> purchaseItemPrices) {
        return Sale.computePurchaseTotal(purchaseItemPrices).intValue();
    }
}
