import org.example.Discount;
import org.example.Product;
import org.example.ProductCategory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void testProductConstructorAndGetters() {
        String productName = "Apple";
        ProductCategory productCategory = ProductCategory.FRUIT;
        BigDecimal price = BigDecimal.valueOf(0.35);
        Discount discount = Discount.NO_DISCOUNT;

        Product product = new Product(productName, productCategory, price, discount);

        // Verify constructor sets fields correctly
        assertEquals(productName, product.getProductName());
        assertEquals(productCategory, product.getProductCategory());
        assertEquals(price.doubleValue(), product.getPrice().doubleValue(), 0.001f);
        assertEquals(discount, product.getDiscount());
    }

    @Test
    public void testProductSetters() {
        Product product = Product.builder()
                .productName("Banana")
                .productCategory(ProductCategory.FRUIT)
                .price(BigDecimal.valueOf(0.20f))
                .discount(Discount.NO_DISCOUNT)
                .build();

        // Verify setter methods
        product.setProductName("Orange");
        assertEquals("Orange", product.getProductName());

        product.setProductCategory(ProductCategory.FRUIT);
        assertEquals(ProductCategory.FRUIT, product.getProductCategory());

        product.setPrice(BigDecimal.valueOf(0.25f));
        assertEquals(0.25, product.getPrice().doubleValue(), 0.001);

        product.setDiscount(Discount.BUY_ONE_GET_ONE_FREE);
        assertEquals(Discount.BUY_ONE_GET_ONE_FREE, product.getDiscount());
    }
}