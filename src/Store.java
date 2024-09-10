import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Store {
    private List<Product> products = new ArrayList<>();
    private List<Cashier> cashiers = new ArrayList<>();
    private List<Receipt> receipts = new ArrayList<>();
    private double totalRevenue = 0;
    private double totalCosts = 0;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    public void sellProduct(Order order, Cashier cashier) throws NotEnoughStockException {
        Receipt receipt = cashier.processSale(order);
        receipts.add(receipt);
        totalRevenue += receipt.getTotalPrice();  // Use the getter method here
    }


    public double calculateCosts() {
        double costs = 0;
        for (Product product : products) {
            costs += product.getQuantity() * product.getDeliveryPrice();  // Use getter here
        }
        for (Cashier cashier : cashiers) {
            costs += cashier.getSalary();  // Use getter here
        }
        totalCosts = costs;
        return costs;
    }

    public double calculateProfit() {
        return totalRevenue - totalCosts;
    }

    public void readReceiptFromFile(int receiptNumber) {
        String fileName = "receipt_" + receiptNumber + ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading receipt file: " + fileName);
        }
    }
}
