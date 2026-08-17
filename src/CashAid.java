public class CashAid extends Aid {
    public CashAid(int aidId, int stock) {

        super(aidId, stock);
    }

    @Override
    public String getAidName() {

        return "Cash Aid";
    }

    @Override
    public int calculateEntitlement(Family family) {

        return family.getFamilyMembers() * 150;
    }

    @Override
    public String getDetails(Family family) {

        return "Entitled amount: " + calculateEntitlement(family) + " shekels";
    }
}
