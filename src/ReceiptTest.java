import org.junit.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ReceiptTest {

    @Test
    public void testReceiptCreationAndFileSaving() throws IOException, NotEnoughStockException {
        Cashier john = new Cashier(1, "John", 1500, 1);
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.now().plusDays(10), 10);
        Order order = new Order(Arrays.asList(apple));

        Receipt receipt = john.processSale(order);
        receipt.generateReceipt();  // Saves receipt to file

        // Read from file
        String receiptContent = Receipt.readReceiptFromFile(receipt.getReceiptNumber());  // Use getReceiptNumber() here
        assertTrue(receiptContent.contains("Receipt Number"));
        assertTrue(receiptContent.contains("John"));
        assertTrue(receiptContent.contains("Apple"));
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
