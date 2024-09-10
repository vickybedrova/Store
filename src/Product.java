import java.time.LocalDate;

public class Product {
    private int id;
    private String name;
    private double deliveryPrice;
    private String category; // "food" or "non-food"
    private LocalDate expiryDate;
    private int quantity;

    public Product(int id, String name, double deliveryPrice, String category, LocalDate expiryDate, int quantity) {
        this.id = id;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
        this.category = category;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public double calculateSellingPrice(double markupPercentage, int daysToExpiry, double discountPercentage) {
        double sellingPrice = deliveryPrice * (1 + markupPercentage / 100);
        if (expiryDate.isBefore(LocalDate.now().plusDays(daysToExpiry))) {
            sellingPrice *= (1 - discountPercentage / 100);
        }
        return sellingPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public String getCategory() {
        return category;
    }
}
