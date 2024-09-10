public class Register {
    private int registerId;
    private Cashier cashier;

    public Register(int registerId) {
        this.registerId = registerId;
    }

    public void assignCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void removeCashier() {
        this.cashier = null;
    }

    public boolean isOccupied() {
        return cashier != null;
    }
}
