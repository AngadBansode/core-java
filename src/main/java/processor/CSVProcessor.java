package processor;

import java.util.*;

public class CSVProcessor {
    public static List<List<String>> processCSV(List<String> csvLines) {
        List<List<String>> processedCSV = new ArrayList<>();
        int maxColumns = 0;

        // Split rows and determine the max number of columns
        List<List<String>> tempData = new ArrayList<>();
        for (String line : csvLines) {
            List<String> row = new ArrayList<>(Arrays.asList(line.split(",")));
            tempData.add(row);
            maxColumns = Math.max(maxColumns, row.size());
        }

        // Process each row to fill missing values
        for (List<String> row : tempData) {
            while (row.size() < maxColumns) {
                row.add("_"); // Fill missing columns with "_"
            }
            for (int i = 0; i < row.size(); i++) {
                if (row.get(i).trim().isEmpty()) {
                    row.set(i, isNumericColumn(tempData, i) ? "0" : "_");
                }
            }
            processedCSV.add(row);
        }

        return processedCSV;
    }

    private static boolean isNumericColumn(List<List<String>> data, int columnIndex) {
        for (List<String> row : data) {
            if (columnIndex < row.size() && !row.get(columnIndex).trim().isEmpty()) {
                try {
                    Integer.parseInt(row.get(columnIndex).trim());
                    return true;
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> csvLines = Arrays.asList(
                "12,hello,",
                "34,,world",
                ",56,test"
        );

        List<List<String>> result = processCSV(csvLines);
        System.out.println("first list: " + result.get(0));
        for (List<String> row : result) {
            System.out.println(String.join(",", row));
        }
    }
}
