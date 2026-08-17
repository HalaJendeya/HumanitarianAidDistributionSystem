public class MedicalAid extends Aid {
    public MedicalAid(int aidId, int stock) {

        super(aidId, stock);
    }

    @Override
    public String getAidName() {

        return "Medical Aid";
    }

    @Override
    public boolean isEligible(Family family) {

        return family.hasMedicalCase();
    }

    @Override
    public int calculateEntitlement(Family family) {

        return 1;
    }

    @Override
    public String getDetails(Family family) {

        return "Medical aid package: 1";
    }
}
