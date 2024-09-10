import java.util.List;

public class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public Receipt createReceipt(Cashier cashier) throws NotEnoughStockException {
        double totalPrice = 0;
        for (Product product : products) {
            if (product.getQuantity() <= 0) {
                throw new NotEnoughStockException("Not enough stock for product: " + product.getName());
            }
            totalPrice += product.calculateSellingPrice(20, 5, 10);
            product.reduceQuantity(1);
        }
        return new Receipt(cashier, products, totalPrice);
    }
}
