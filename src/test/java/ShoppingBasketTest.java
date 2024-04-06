import org.example.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    private ShoppingBasket shoppingBasket;
    private Product apple;
    private Product banana;
    private Product melon;
    private Product lime;

    @Before
    public void setUp() {
        shoppingBasket = new ShoppingBasket();
        shoppingBasket.setUser(new User());
        apple = Product.builder().productName("Apple").productCategory(ProductCategory.FRUIT).price(BigDecimal.valueOf(0.35)).discount(Discount.NO_DISCOUNT).build();
        banana = Product.builder().productName("Banana").productCategory(ProductCategory.FRUIT).price(BigDecimal.valueOf(0.20F)).discount(Discount.NO_DISCOUNT).build();
        melon = Product.builder().productName("Melon").productCategory(ProductCategory.FRUIT).price(BigDecimal.valueOf(0.50F)).discount(Discount.BUY_ONE_GET_ONE_FREE).build();
        lime = Product.builder().productName("Lime").productCategory(ProductCategory.FRUIT).price(BigDecimal.valueOf(0.15F)).discount(Discount.THREE_FOR_PRICE_OF_TWO).build();
    }

    @Test
    public void testCheckoutWithNoProducts() {
        assertEquals(0.0, shoppingBasket.checkout().doubleValue(), 0.001);
    }

    @Test
    public void testCheckoutWithOneProduct() {
        shoppingBasket.addProductQuantity(apple, 1);
        assertEquals(0.35d, shoppingBasket.checkout().doubleValue(), 0.001);
    }

    @Test
    public void testCheckoutWithMultipleProducts() {
        shoppingBasket.addProductQuantity(apple, 1);
        shoppingBasket.addProductQuantity(banana, 2);
        shoppingBasket.addProductQuantity(melon, 2);
        shoppingBasket.addProductQuantity(lime, 3);

        // Total price: 0.35 + 0.20 * 2 + (0.50 / 2) * 2 + (0.15 * 3) - 0.15 = 1.55
        assertEquals(1.55F, shoppingBasket.checkout().doubleValue(), 0.001);
    }

    @Test
    public void testAddProductQuantity() throws NoSuchFieldException, IllegalAccessException {
        shoppingBasket.addProductQuantity(apple, 2);
        Field shoppingCartField = ShoppingBasket.class.getDeclaredField("shoppingCart");
        shoppingCartField.setAccessible(true);
        @SuppressWarnings("unchecked")
        Map<Product, Integer> shoppingCart = (Map<Product, Integer>) shoppingCartField.get(shoppingBasket);
        assertEquals(2, (int) shoppingCart.get(apple));
    }

    @Test
    public void testReduceProductQuantity() throws NoSuchFieldException, IllegalAccessException {
        shoppingBasket.addProductQuantity(apple, 3);

        Field shoppingCartField = ShoppingBasket.class.getDeclaredField("shoppingCart");
        shoppingCartField.setAccessible(true);
        shoppingBasket.reduceProductQuantity(apple, 2);

        @SuppressWarnings("unchecked")
        Map<Product, Integer> shoppingCart = (Map<Product, Integer>) shoppingCartField.get(shoppingBasket);

        // Verify that the quantity of the product in the shopping cart is as expected
        assertEquals(1, (int) shoppingCart.get(apple));
    }

    @Test
    public void testUpdateProductQuantity() throws NoSuchFieldException, IllegalAccessException {
        shoppingBasket.addProductQuantity(apple, 3);
        Field shoppingCartField = ShoppingBasket.class.getDeclaredField("shoppingCart");
        shoppingCartField.setAccessible(true);
        shoppingBasket.updateProductQuantity(apple, 5);
        @SuppressWarnings("unchecked")
        Map<Product, Integer> shoppingCart = (Map<Product, Integer>) shoppingCartField.get(shoppingBasket);
        assertEquals(5, (int) shoppingCart.get(apple));
    }
}
