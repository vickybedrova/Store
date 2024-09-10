import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;

public class ProductTest {

    @Test
    public void testCalculateSellingPriceWithoutDiscount() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 100);
        double sellingPrice = apple.calculateSellingPrice(20, 5, 10);
        assertEquals(1.20, sellingPrice, 0.01);  // Expecting 20% markup
    }

    @Test
    public void testCalculateSellingPriceWithDiscount() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(3), 100);
        double sellingPrice = apple.calculateSellingPrice(20, 5, 10);
        assertEquals(1.08, sellingPrice, 0.01);  // Expecting 20% markup, then 10% discount
    }

    @Test
    public void testProductIsExpired() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().minusDays(1), 100);
        assertTrue(apple.isExpired());
    }

    @Test
    public void testProductIsNotExpired() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 100);
        assertFalse(apple.isExpired());
    }
}
