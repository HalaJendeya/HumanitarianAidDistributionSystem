public class NonFoodAid extends Aid {

    private final boolean winterSeason;

    public NonFoodAid(int aidId, int stock, boolean winterSeason) {
        super(aidId, stock);
        this.winterSeason = winterSeason;
    }

    @Override
    public String getAidName() {

        return "Non-Food Items";
    }

    @Override
    public int calculateEntitlement(Family family) {
        int quantity = family.getFamilyMembers();
        if (winterSeason) quantity++;
        return quantity;
    }

    @Override
    public String getDetails(Family family) {

        return "Entitled non-food items: " + calculateEntitlement(family);
    }
}
