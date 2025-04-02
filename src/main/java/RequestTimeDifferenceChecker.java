import java.time.LocalDateTime;
import java.time.Duration;

public class RequestTimeDifferenceChecker {
    // Method to check if the difference between two times is one minute
    public static boolean isOneMinuteDifference(LocalDateTime requestTime1, LocalDateTime requestTime2) {
        Duration duration = Duration.between(requestTime1, requestTime2);
        return Math.abs(duration.toMinutes()) == 1;
    }

    public static void main(String[] args) throws InterruptedException {
        // Simulate request times
        LocalDateTime requestTime1 = LocalDateTime.now();
        Thread.sleep(Duration.ofMinutes(2));
        // Simulating a second request made 1 minute later
        LocalDateTime requestTime2 =  LocalDateTime.now();//requestTime1.plusMinutes(1);

        // Check if the time difference is exactly one minute
        if (isOneMinuteDifference(requestTime1, requestTime2)) {
            System.out.println("The time difference is exactly 1 minute.");
        } else {
            System.out.println("The time difference is not 1 minute.");
        }
    }

}
