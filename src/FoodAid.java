public class FoodAid extends Aid {
    public FoodAid(int aidId, int stock) {

        super(aidId, stock);
    }

    @Override
    public String getAidName() {

        return "Food Aid";
    }

    @Override
    public int calculateEntitlement(Family family) {

        return 1; // سلة وحدة من الكمية
    }

    @Override
    public String getDetails(Family family) {
        int rice = family.getFamilyMembers() * 2;
        int sugar = family.getFamilyMembers();
        return "Entitled quantity:"
                + "\n- Rice: " + rice + " kg"
                + "\n- Sugar: " + sugar + " kg"
                + "\n- Basic food basket: 1";
    }
}
