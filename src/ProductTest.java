import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testCalculateSellingPriceWithoutDiscount() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 100);
        double sellingPrice = apple.calculateSellingPrice(20, 5, 10);  // 20% markup, discount within 5 days
        assertEquals(1.20, sellingPrice, 0.01);  // Expecting 20% markup, no discount
    }

    @Test
    public void testCalculateSellingPriceWithDiscount() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(3), 100);
        double sellingPrice = apple.calculateSellingPrice(20, 5, 10);  // 20% markup, discount within 5 days
        assertEquals(1.08, sellingPrice, 0.01);  // 20% markup, 10% discount as it's close to expiration
    }

    @Test
    public void testProductIsExpired() {
        Product expiredProduct = new Product(1, "Milk", 1.50, "food", LocalDate.now().minusDays(1), 100);
        assertTrue(expiredProduct.isExpired());
    }

    @Test
    public void testProductIsNotExpired() {
        Product freshProduct = new Product(1, "Milk", 1.50, "food", LocalDate.now().plusDays(30), 100);
        assertFalse(freshProduct.isExpired());
    }
}
