package code;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();

        String binaryRepresentation = convertToBinary(decimalNumber);

        Long no = Long.parseLong(binaryRepresentation);

        System.out.println("Binary representation: " + no);

        scanner.close();
    }

    private static String convertToBinary(int decimalNumber) {
        StringBuilder binary = new StringBuilder();

        if (decimalNumber == 0) {
            binary.append("0");
        } else {
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 2;
                binary.insert(0, remainder);
                decimalNumber /= 2;
            }
        }

        return binary.toString();
    }
}
