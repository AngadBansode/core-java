package threads;

public class ActiveThreadsExample {
    public static void main(String[] args) {
        // Get the active thread count
        int activeCount = Thread.activeCount();
        System.out.println("Active Thread Count: " + activeCount);

        // Create an array to hold the active threads
        Thread[] activeThreads = new Thread[activeCount];

        // Enumerate active threads into the array
        Thread.enumerate(activeThreads);

        // Print details of each active thread
        for (Thread thread : activeThreads) {
            System.out.println("Thread Name: " + thread.getName());
            System.out.println("Thread State: " + thread.getState());
        }
    }
}
