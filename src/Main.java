import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Family> families = new ArrayList<>();
        ArrayList<Aid> aids = new ArrayList<>();
        ArrayList<DistributionRecord> records = new ArrayList<>();

        // Initial registered families
        families.add(new Family(1001, "Gaza City", "Ahmed Ali", 5,
                "2026-01-10", false));
        families.add(new Family(1002, "Khan Younis", "Sara Hassan", 3,
                "2026-02-05", true));
        families.add(new Family(1003, "Rafah", "Mohammad Salem", 6,
                "2026-03-12", false));

        // Initial aid stock
        aids.add(new FoodAid(1, 50));
        aids.add(new MedicalAid(2, 10));
        aids.add(new CashAid(3, 10000));
        aids.add(new NonFoodAid(4, 100, true));

        int choice;
        do {
            System.out.println("\n====================================");
            System.out.println("Humanitarian Aid Distribution System");
            System.out.println("====================================");
            System.out.println("1. Display Families");
            System.out.println("2. Distribute Aid");
            System.out.println("3. Exit");

            choice = readInt(scanner, "Choose operation: ");

            switch (choice) {
                case 1 -> displayFamilies(families);
                case 2 -> distributeAid(families, aids, records, scanner);
                case 3 -> System.out.println("Thank you for using the system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void displayFamilies(ArrayList<Family> families) {
        System.out.println("\n--- Registered Families ---");
        for (Family family : families) {
            family.displayInfo();
            System.out.println("----------------------");
        }
    }

    public static void distributeAid(
            ArrayList<Family> families,
            ArrayList<Aid> aids,
            ArrayList<DistributionRecord> records,
            Scanner scanner
    ) {
        try {
            int familyId = readInt(scanner, "Enter family registration ID: ");
            Family family = findFamilyById(families, familyId);

            if (family == null) {
                throw new Exception("Error: Family registration ID not found.");
            }

            System.out.println("\nChoose aid type:");
            System.out.println("1. Food Aid");
            System.out.println("2. Medical Aid");
            System.out.println("3. Cash Aid");
            System.out.println("4. Non-Food Items");

            int aidId = readInt(scanner, "Your choice: ");
            Aid aid = findAidById(aids, aidId);

            if (aid == null) {
                throw new Exception("Error: Invalid aid type.");
            }

            if (hasReceivedSameAidThisMonth(records, familyId, aidId)) {
                throw new Exception("Error: This aid type was already distributed to this family this month.");
            }

            if (!aid.isEligible(family)) {
                throw new Exception("Error: Medical aid requires a registered medical case.");
            }

            int entitlement = aid.calculateEntitlement(family);

            if (!aid.hasEnoughStock(entitlement)) {
                throw new Exception("Error: Insufficient stock.");
            }

            aid.reduceStock(entitlement);
            records.add(new DistributionRecord(familyId, aidId));

            System.out.println("\n------------------------------------");
            System.out.println(aid.getAidName() + " distributed successfully.");
            System.out.println("Family ID: " + family.getRegistrationId());
            System.out.println("Family Head: " + family.getHeadName());
            System.out.println("Family Members: " + family.getFamilyMembers());
            System.out.println(aid.getDetails(family));
            System.out.println("Stock updated successfully.");
            System.out.println("------------------------------------");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Family findFamilyById(ArrayList<Family> families, int familyId) {
        for (Family family : families) {
            if (family.getRegistrationId() == familyId) return family;
        }
        return null;
    }

    public static Aid findAidById(ArrayList<Aid> aids, int aidId) {
        for (Aid aid : aids) {
            if (aid.getAidId() == aidId) return aid;
        }
        return null;
    }

    public static boolean hasReceivedSameAidThisMonth(
            ArrayList<DistributionRecord> records,
            int familyId,
            int aidId
    ) {
        for (DistributionRecord record : records) {
            if (record.getFamilyId() == familyId
                    && record.getAidId() == aidId
                    && record.getMonth().equals(YearMonth.now())) {
                return true;
            }
        }
        return false;
    }

    public static int readInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }
}
