import org.example.ProductCategory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductCategoryTest {

    @Test
    public void testProductCategoryEnumValues() {
        assertEquals(9, ProductCategory.values().length);

        assertEquals("FRUIT", ProductCategory.FRUIT.name());
        assertEquals("CLOTHING", ProductCategory.CLOTHING.name());
        assertEquals("VEGETABLE", ProductCategory.VEGETABLE.name());
        assertEquals("STATIONARY", ProductCategory.STATIONARY.name());
        assertEquals("DAIRY", ProductCategory.DAIRY.name());
        assertEquals("MEAT", ProductCategory.MEAT.name());
        assertEquals("BEVERAGE", ProductCategory.BEVERAGE.name());
        assertEquals("SNACK", ProductCategory.SNACK.name());
        assertEquals("OTHER", ProductCategory.OTHER.name());
    }

    @Test
    public void testProductCategoryEnumValuesOrder() {
        ProductCategory[] categories = ProductCategory.values();

        // Ensure the order of enum values
        assertEquals(ProductCategory.FRUIT, categories[0]);
        assertEquals(ProductCategory.CLOTHING, categories[1]);
        assertEquals(ProductCategory.VEGETABLE, categories[2]);
        assertEquals(ProductCategory.STATIONARY, categories[3]);
        assertEquals(ProductCategory.DAIRY, categories[4]);
        assertEquals(ProductCategory.MEAT, categories[5]);
        assertEquals(ProductCategory.BEVERAGE, categories[6]);
        assertEquals(ProductCategory.SNACK, categories[7]);
        assertEquals(ProductCategory.OTHER, categories[8]);
    }
}
