package design.duplicatefinderstrategy;

public class DuplicateFinder {

    private final DuplicateDetectionStrategy strategy;

    public DuplicateFinder(DuplicateDetectionStrategy strategy) {
        this.strategy = strategy;
    }

    public Integer findDuplicate(int[] elements) {
        return strategy.findDuplicate(elements);
    }
}
