import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StoreTest {

    private Store store;

    @Before
    public void setup() {
        store = new Store();
    }

    @Test
    public void testAddProductAndCalculateCosts() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 10);
        store.addProduct(apple);

        Cashier john = new Cashier(1, "John", 1500, 1);
        store.addCashier(john);

        double totalCosts = store.calculateCosts();
        assertEquals(1510, totalCosts, 0.01);  // Cost of products + cashier salary
    }

    @Test
    public void testSellProductAndCalculateRevenue() throws NotEnoughStockException {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 10);
        store.addProduct(apple);

        Cashier john = new Cashier(1, "John", 1500, 1);
        store.addCashier(john);

        Order order = new Order(List.of(apple));
        store.sellProduct(order, john);

        assertEquals(1.20, store.calculateProfit(), 0.01);  // Revenue after selling apple with 20% markup
    }

    @Test
    public void testInsufficientStockException() {
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 0);  // No stock
        store.addProduct(apple);

        Cashier john = new Cashier(1, "John", 1500, 1);
        Order order = new Order(List.of(apple));

        try {
            store.sellProduct(order, john);
            fail("Expected NotEnoughStockException to be thrown");
        } catch (NotEnoughStockException e) {
            assertEquals("Not enough stock for product: Apple", e.getMessage());
        }
    }
}
