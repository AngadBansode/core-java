import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {
    private final int maxRequests; // Maximum allowed requests
    private final long timeWindow; // Time window in milliseconds
    private final ConcurrentHashMap<String, RequestBucket> userBuckets = new ConcurrentHashMap<>();

    // Constructor
    public RateLimiter(int maxRequests, long timeWindow) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeWindow;
    }

    // Method to check if a request is allowed
    public boolean isAllowed(String userId) {
        // Get or create the bucket for the user
        userBuckets.putIfAbsent(userId, new RequestBucket());
        RequestBucket bucket = userBuckets.get(userId);

        synchronized (bucket) {
            long currentTime = Instant.now().toEpochMilli();

            // Clear old requests outside the time window
            bucket.requests.removeIf(timestamp -> timestamp <= currentTime - timeWindow);

            // Check if the user can make another request
            if (bucket.requests.size() < maxRequests) {
                bucket.requests.add(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }

    // Inner class to store request timestamps
    private static class RequestBucket {
        private final java.util.Queue<Long> requests = new java.util.LinkedList<>();
    }

    // Main method for demonstration
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1000); // 5 requests per second
        String userId = "user123";

        // Simulate user requests
        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.isAllowed(userId);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Blocked"));
//            Thread.sleep(200); // Wait 200ms between requests
        }
    }
}
