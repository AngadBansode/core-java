package processor;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CSVReadJava8 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/data.csv";
        List<String> values = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            // Process lines, skip the header
           /* String second = lines.skip(1).findFirst().get();
            System.out.println("Sec: " + second);*/ // Sec: 101,Angad,25

            lines.skip(1)
                    .map(line -> line.split(","))
                    .forEach(columns -> {
                        for (int i = 0; i < columns.length; i++) { // 101, Angad, 25
                            if (columns[i].isEmpty()) {
                                columns[i] = "EMPTY"; // Mark empty cells
                            }
                        }
                        System.out.println(Arrays.toString(columns));
                        values.add(Arrays.toString(columns));
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }

         for(String col: values){
            String [] sarr=   col.split(",");
             System.out.println("ID: " + sarr[0]);
             System.out.println("Name: " + sarr[1]);
             System.out.println("Age: " + sarr[2]);
         }

    }
}
