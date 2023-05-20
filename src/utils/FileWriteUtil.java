package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteUtil {

    public static void WriteCsvFile(String csvString){
        File file = new File("papers.csv");

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("CSV file created.");
            }

            FileWriter writer = new FileWriter(file, false);
            writer.append(csvString);
            writer.flush();
            writer.close();

            System.out.println("String has been written to the CSV file.");
        } catch (IOException e) {
            System.out.println("Error writing to the CSV file: " + e.getMessage());
        }
    }
}
