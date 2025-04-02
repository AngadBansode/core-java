package rmi.string;

public class NumberToWords {

    // Arrays to store words for numbers
    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] thousands = {
            "", "Thousand", "Million", "Billion"
    };

    // Method to convert a number to words
    private static String convertToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String words = "";
        int thousandIndex = 0;

        while (num > 0) {
            int chunk = num % 1000; // Process in chunks of 3 digits
            if (chunk > 0) {
                words = processChunk(chunk) + " " + thousands[thousandIndex] + " " + words;
            }
            num /= 1000;
            thousandIndex++;
        }

        return words.trim();
    }

    // Helper method to process a 3-digit chunk
    private static String processChunk(int num) {
        String chunkWords = "";

        if (num >= 100) {
            chunkWords += units[num / 100] + " Hundred ";
            num %= 100;
        }

        if (num >= 20) {
            chunkWords += tens[num / 10] + " ";
            num %= 10;
        }

        if (num > 0) {
            chunkWords += units[num] + " ";
        }

        return chunkWords.trim();
    }

    // Main method to test the program
    public static void main(String[] args) {
        int number = 123;
        String words = convertToWords(number);
        System.out.println("Number: " + number);
        System.out.println("In words: " + words);
    }
}
