public class Family {
    private final int registrationId;
    private final String village;
    private final String headName;
    private final int familyMembers;
    private final String registrationDate;
    private final boolean hasMedicalCase;

    public Family(int registrationId, String village, String headName,
                  int familyMembers, String registrationDate, boolean hasMedicalCase) {
        this.registrationId = registrationId;
        this.village = village;
        this.headName = headName;
        this.familyMembers = familyMembers;
        this.registrationDate = registrationDate;
        this.hasMedicalCase = hasMedicalCase;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public String getVillage() {
        return village;
    }

    public String getHeadName() {
        return headName;
    }

    public int getFamilyMembers() {
        return familyMembers;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public boolean hasMedicalCase() {
        return hasMedicalCase;
    }

    public void displayInfo() {
        System.out.println("Family registration ID: " + registrationId
                + "\nVillage: " + village
                + "\nFamily head: " + headName
                + "\nFamily members: " + familyMembers
                + "\nRegistration date: " + registrationDate
                + "\nMedical case registered: " + hasMedicalCase);
    }
}
