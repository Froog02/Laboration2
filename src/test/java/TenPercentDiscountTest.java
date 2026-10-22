import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.noah.webshop.model.HalfPriceDiscount;
import se.iths.noah.webshop.model.TenPercentDiscount;

class TenPercentDiscountTest {

    @Test
    void ShouldReturntenpercent() {
        TenPercentDiscount tenPercentDiscount = new TenPercentDiscount("");
        double price = 100.0;
        double rabattPris = tenPercentDiscount.calculatePrice(price);

        Assertions.assertEquals(rabattPris, 90);
    }
}

class HalfPriceDiscountTest {

    @Test
    void ShouldReturnHalf() {
        HalfPriceDiscount halfPriceDiscount = new HalfPriceDiscount("");
        double price = 100.0;
        double rabattPris = halfPriceDiscount.calculatePrice(price);
        Assertions.assertEquals(rabattPris, 50);
    }
}
