import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Product apple = new Product(1, "Apple", 1.00, "food", LocalDate.of(2024, 12, 31), 100);
        Product soap = new Product(2, "Soap", 2.50, "non-food", LocalDate.of(2025, 12, 31), 50);

        store.addProduct(apple);
        store.addProduct(soap);

        Cashier john = new Cashier(1, "John", 1500, 1);  // John works at register 1
        Cashier jane = new Cashier(2, "Jane", 1600, 2);  // Jane works at register 2

        store.addCashier(john);
        store.addCashier(jane);

        System.out.println(john.getName() + " is working at register " + john.getRegisterId());
        System.out.println(jane.getName() + " is working at register " + jane.getRegisterId());

        john.setRegisterId(2);
        System.out.println(john.getName() + " is now working at register " + john.getRegisterId());

        Order order = new Order(Arrays.asList(apple, soap));

        try {
            store.sellProduct(order, john);
            Receipt receipt = john.processSale(order);
            receipt.printReceipt();
        } catch (NotEnoughStockException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total Costs: " + store.calculateCosts());
        System.out.println("Total Profit: " + store.calculateProfit());
        System.out.println("Total Receipts Issued: " + Receipt.getTotalReceiptsIssued());
    }
}
