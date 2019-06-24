package com.plusonetesting.rtdd.clientfirstdesign;

import com.plusonetesting.rtdd.pointofsale.Sale;
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
            allowing(catalog).findPrice(with("::product found::"));
            will(returnValue(irrelevantPrice));

            oneOf(display).displayPrice(with(irrelevantPrice));
        }});

        SaleController saleController = new SaleController(catalog, display);
        saleController.onBarcode("::product found::");
    }

    @Test
    public void productNotFound() {
        Catalog catalog = context.mock(Catalog.class);
        Display display = context.mock(Display.class);

        context.checking(new Expectations() {{
            allowing(catalog).findPrice(with("::product not found::"));
            will(returnValue(null));

            oneOf(display).displayProductNotFoundMessage(with("::product not found::"));
        }});

        SaleController saleController = new SaleController(catalog, display);
        saleController.onBarcode("::product not found::");
    }

    @Test
    public void emptyBarcode() {
        Display display = context.mock(Display.class);

        context.checking(new Expectations() {{

            oneOf(display).displayEmptyBarcodeMessage();
        }});

        SaleController saleController = new SaleController(null, display);
        saleController.onBarcode("");
    }

    public interface Catalog {
        Price findPrice(String barCode);
    }

    public interface Display {
        void displayPrice(Price price);

        void displayProductNotFoundMessage(String barcodeNotFound);

        void displayEmptyBarcodeMessage();
    }

    public static class SaleController {
        private Catalog catalog;
        private Display display;

        public SaleController(Catalog catalog, Display display) {
            this.catalog = catalog;
            this.display = display;
        }

        public void onBarcode(String barcode) {
            //SMELL Should I get an empty barcode at all? Ever?
            if ("".equals(barcode)) {
                display.displayEmptyBarcodeMessage();
                return;
            }

            Price price = catalog.findPrice(barcode);

            if (price == null)
                display.displayProductNotFoundMessage(barcode);
            else
                display.displayPrice(price);
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
