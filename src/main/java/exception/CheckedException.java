package exception;

import java.io.IOException;

public class CheckedException {

    public static void main(String[] args) {
        try {
            // Method that throws a checked exception
            riskyMethod();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // Method that declares a checked exception
    public static void riskyMethod() throws IOException {
        throw new IOException("This is a checked exception.");
    }
}
