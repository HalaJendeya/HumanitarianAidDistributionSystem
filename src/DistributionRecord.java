import java.time.YearMonth;

public class DistributionRecord {
    private final int familyId;
    private final int aidId;
    private final YearMonth month;

    public DistributionRecord(int familyId, int aidId) {
        this.familyId = familyId;
        this.aidId = aidId;
        this.month = YearMonth.now();
    }

    public int getFamilyId() {
        return familyId;
    }

    public int getAidId() {
        return aidId;
    }

    public YearMonth getMonth() {
        return month;
    }
}
