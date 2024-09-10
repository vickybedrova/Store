public class Cashier {
    private int id;
    private String name;
    private double salary;
    private int registerId;


    public Cashier(int id, String name, double salary, int registerId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.registerId = registerId;
    }

    public Receipt processSale(Order order) throws NotEnoughStockException {
        return order.createReceipt(this);
    }

    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

}
