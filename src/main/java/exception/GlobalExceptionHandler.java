package exception;

public class GlobalExceptionHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println("Unhandled exception caught: " + throwable.getMessage());
        });

        // Example of an uncaught exception
        int result = 10 / 0; // This will trigger the global handler
    }
}
