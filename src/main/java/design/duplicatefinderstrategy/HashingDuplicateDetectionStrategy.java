package design.duplicatefinderstrategy;

import java.util.HashSet;

public class HashingDuplicateDetectionStrategy implements DuplicateDetectionStrategy {

    @Override
    public Integer findDuplicate(int[] elements) {
        HashSet<Integer> seen = new HashSet<>();
        for (int element : elements) {
            if (!seen.add(element)) {
                return element; // Duplicate found
            }
        }
        return null; // No duplicate found
    }
}