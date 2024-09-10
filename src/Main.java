import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        // Create some products
        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.of(2024, 12, 31), 100);
        Product soap = new Product(2, "Soap", 2.50, "non-food", LocalDate.of(2025, 12, 31), 50);

        // Add products to the store
        store.addProduct(apple);
        store.addProduct(soap);

        // Create cashiers
        Cashier john = new Cashier(1, "John", 1500, 1);  // John works at register 1
        Cashier jane = new Cashier(2, "Jane", 1600, 2);  // Jane works at register 2

        // Add cashiers to the store
        store.addCashier(john);
        store.addCashier(jane);

        // Print initial registers
        System.out.println(john.getName() + " is working at register " + john.getRegisterId());
        System.out.println(jane.getName() + " is working at register " + jane.getRegisterId());

        // Change John's register to 2
        john.setRegisterId(2);
        System.out.println(john.getName() + " is now working at register " + john.getRegisterId());

        // Create an order
        Order order = new Order(Arrays.asList(apple, soap));

        // Try selling products with john as the cashier
        try {
            store.sellProduct(order, john);  // Use john to sell the product
        } catch (NotEnoughStockException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Read receipt #1 from file
            String receiptContent = Receipt.readReceiptFromFile(1);
            System.out.println("Receipt #1 Contents:");
            System.out.println(receiptContent);
        } catch (IOException e) {
            System.out.println("Error reading receipt: " + e.getMessage());
        }

        // Calculate profit
        System.out.println("Total Costs: " + store.calculateCosts());
        System.out.println("Total Profit: " + store.calculateProfit());
        System.out.println("Total Receipts Issued: " + Receipt.getTotalReceiptsIssued());
    }
}
