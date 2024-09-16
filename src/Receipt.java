import java.time.LocalDateTime;
import java.util.List;

public class Receipt {
    private static int receiptCounter = 0;
    private int receiptNumber;
    private Cashier cashier;
    private LocalDateTime dateTime;
    private List<Product> products;
    private double totalPrice;

    public Receipt(Cashier cashier, List<Product> products, double totalPrice) {
        this.receiptNumber = ++receiptCounter;
        this.cashier = cashier;
        this.dateTime = LocalDateTime.now();
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void printReceipt() {
        System.out.println("Receipt Number: " + receiptNumber);
        System.out.println("Cashier: " + cashier.getName());
        System.out.println("Date: " + dateTime);
        System.out.println("Products: ");
        for (Product product : products) {
            System.out.println(" - " + product.getName() + ", Quantity: 1, Price: " + product.calculateSellingPrice(20, 5, 10));
        }
        System.out.println("Total Price: " + totalPrice);
    }

    public static int getTotalReceiptsIssued() {
        return receiptCounter;
    }
    //reset receipt counter (to be used in tests)
    public static void resetReceiptCounter() {
        receiptCounter = 0;
    }
}
