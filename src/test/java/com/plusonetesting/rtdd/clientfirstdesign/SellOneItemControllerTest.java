package com.plusonetesting.rtdd.clientfirstdesign;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class SellOneItemControllerTest {

    @Rule
    public final JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void productFound() {
        final Catalog catalog = context.mock(Catalog.class);
        final Display display = context.mock(Display.class);
        final Price irrelevantPrice = Price.cents(795);

        context.checking(new Expectations() {{
            allowing(catalog).findPrice(with("12345"));
            will(returnValue(irrelevantPrice));

            oneOf(display).displayPrice(with(irrelevantPrice));
        }});

        SaleController saleController = new SaleController(catalog, display);
        saleController.onBarcode("12345");
    }

    public interface Catalog {
        Price findPrice(String barCode);
    }

    public interface Display {
        void displayPrice(Price price);
    }

    public static class SaleController {
        private Catalog catalog;
        private Display display;

        public SaleController(Catalog catalog, Display display) {
            this.catalog = catalog;
            this.display = display;
        }

        public void onBarcode(String barCode) {
            display.displayPrice(catalog.findPrice(barCode));
        }
    }


    public static class Price {
        public static Price cents(int centsValues) {
            return new Price();
        }

        @Override
        public String toString() {
            return "a Price";
        }
    }

}
