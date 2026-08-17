public abstract class Aid {
    private final int aidId;
    private int stock;

    public Aid(int aidId, int stock) {
        this.aidId = aidId;
        this.stock = stock;
    }

    public int getAidId() {
        return aidId;
    }
    public int getStock() {
        return stock;
    }

    public boolean hasEnoughStock(int requiredAmount) {

        return stock >= requiredAmount;
    }

    public void reduceStock(int amount) {

        stock -= amount;
    }

    public boolean isEligible(Family family) {

        return true;
    }

    public abstract String getAidName();
    public abstract int calculateEntitlement(Family family);
    public abstract String getDetails(Family family);
}
