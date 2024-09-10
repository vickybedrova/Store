import java.time.LocalDateTime;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

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

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Method to generate and save the receipt to a file
    public void generateReceipt() throws IOException {
        String fileName = "receipt_" + receiptNumber + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Receipt Number: " + receiptNumber + "\n");
            writer.write("Cashier: " + cashier.getName() + "\n");
            writer.write("Date: " + dateTime + "\n");
            writer.write("Products: \n");
            for (Product product : products) {
                writer.write(" - " + product.getName() + "\n");
            }
            writer.write("Total Price: " + totalPrice + "\n");
        }
    }
    public static String readReceiptFromFile(int receiptNumber) throws IOException {
        String fileName = "receipt_" + receiptNumber + ".txt";
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
    public static int getTotalReceiptsIssued() {
        return receiptCounter;
    }
}
