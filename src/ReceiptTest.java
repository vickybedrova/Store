import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ReceiptTest {

    @Before
    public void setUp() {
        //reset receipt counter before each test
        Receipt.resetReceiptCounter();
    }

    @Test
    public void testReceiptCreationAndPrinting() throws NotEnoughStockException {
        Cashier john = new Cashier(1, "John", 1500, 1);
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 10);
        Order order = new Order(Arrays.asList(apple));

        Receipt receipt = john.processSale(order);

        assertNotNull(receipt);
        assertEquals(1, receipt.getReceiptNumber());  // First receipt should have number 1
        assertEquals("John", receipt.getCashier().getName());  // Check that John is the cashier
        assertEquals(1.20, receipt.getTotalPrice(), 0.01);  // Ensure the total price is calculated correctly
    }

    @Test
    public void testGetTotalReceiptsIssued() throws NotEnoughStockException {
        Cashier john = new Cashier(1, "John", 1500, 1);
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 10);
        Order order = new Order(Arrays.asList(apple));

        john.processSale(order);  // First receipt
        john.processSale(order);  // Second receipt

        assertEquals(2, Receipt.getTotalReceiptsIssued());
    }
}
