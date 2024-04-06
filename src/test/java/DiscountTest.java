import org.example.Discount;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    @Test
    public void testApplyDiscountBuyOneGetOneFree() {
        Discount discount = Discount.BUY_ONE_GET_ONE_FREE;

        // Apply discount for quantity 2 and price 1.0
        BigDecimal discountedPrice = discount.applyDiscount(2, BigDecimal.valueOf(1.0));

        // Expected result: 1.0 (1 * 1.0)
        assertEquals(1.0, discountedPrice.doubleValue(), 0.001);
    }

    @Test
    public void testApplyDiscountThreeForPriceOfTwo() {
        Discount discount = Discount.THREE_FOR_PRICE_OF_TWO;

        // Apply discount for quantity 3 and price 1.0
        BigDecimal discountedPrice = discount.applyDiscount(3, BigDecimal.valueOf(1.0));

        // Expected result: 2.0 (2 * 1.0)
        assertEquals(2.0, discountedPrice.doubleValue(), 0.001);
    }

    @Test
    public void testApplyDiscountNoDiscount() {
        Discount discount = Discount.NO_DISCOUNT;

        // Apply discount for quantity 2 and price 1.0
        BigDecimal discountedPrice = discount.applyDiscount(2, BigDecimal.valueOf(1.0));

        // Expected result: 2.0 (2 * 1.0)
        assertEquals(2.0, discountedPrice.doubleValue(), 0.001);
    }
}
