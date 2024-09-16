import java.util.ArrayList;
import java.util.List;

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
        totalRevenue += receipt.getTotalPrice();
    }

    public double calculateCosts() {
        double costs = 0;
        for (Product product : products) {
            costs += product.getQuantity() * product.getDeliveryPrice();
        }
        for (Cashier cashier : cashiers) {
            costs += cashier.getSalary();
        }
        totalCosts = costs;
        return costs;
    }

    public double calculateProfit() {
        return totalRevenue - totalCosts;
    }
}
