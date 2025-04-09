package processor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SimpleCSVReader {
    public static void main(String[] args) {
        String filePath = "src/main/resources/data.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Split by comma
                for (String value : values) {
                    System.out.print(value + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
