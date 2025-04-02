package design.duplicatefinderstrategy;

public class ClientCode {

    public static void main(String[] args) {
        int[] elements = {1, 3, 5, 7, 31, 9, 11,1 }; // Example input

        // Use the Hashing strategy
        DuplicateDetectionStrategy strategy = new HashingDuplicateDetectionStrategy();
        DuplicateFinder duplicateFinder = new DuplicateFinder(strategy);

        Integer duplicate = duplicateFinder.findDuplicate(elements);
        if (duplicate != null) {
            System.out.println("Duplicate element found: " + duplicate);
        } else {
            System.out.println("No duplicate found.");
        }
    }

}
