import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CashierTest {

    @Test
    public void testCashierCreation() {
        Cashier john = new Cashier(1, "John", 1500, 1);
        assertEquals(1, john.getRegisterId());
        assertEquals("John", john.getName());
    }

    @Test
    public void testChangeRegister() {
        Cashier john = new Cashier(1, "John", 1500, 1);
        john.setRegisterId(2);  // Move John to register 2
        assertEquals(2, john.getRegisterId());
    }

    @Test
    public void testCashierProcessSale() throws NotEnoughStockException {
        Cashier john = new Cashier(1, "John", 1500, 1);
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 10);
        Order order = new Order(Arrays.asList(apple));

        Receipt receipt = john.processSale(order);
        assertNotNull(receipt);
        assertEquals(9, apple.getQuantity());
    }
}
