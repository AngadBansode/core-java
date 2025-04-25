package rmi.string;

import java.util.UUID;

public class UniqueIdGenerator {
    public static void main(String[] args) {
        String firstName = "Angad";
        String lastName = "Bansode";
        String uniqueId = generateUniqueID(firstName, lastName);
        System.out.println("UniqueId: " + uniqueId);


    }

    private static String generateUniqueID(String firstName, String lastName) {
        // Trim and convert names to lowercase to ensure consistency
        firstName = firstName.trim().toLowerCase();
        lastName = lastName.trim().toLowerCase();

        // Generate a UUID and combine it with the name initials
        String uuid = UUID.randomUUID().toString().substring(0, 8); // Shortened UUID
        String uniqueId = firstName.charAt(0) + lastName + "_" + uuid;

        return uniqueId;
    }

}
//UniqueId: abansode_3025206e