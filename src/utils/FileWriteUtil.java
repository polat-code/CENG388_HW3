package utils;
/*
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


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

    public static void createReadingListOnJsonFile(String readingListName, String creatorName){
        File file = new File("readingList.json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reading_list_id", 0);
        jsonObject.put("creator_researcher_name", creatorName);
        jsonObject.put("reading_list_name", readingListName);
        jsonObject.put("number_of_papers", 0);
        jsonObject.put("name_of_papers", "");
        List<String> jsonStringList = new ArrayList<>();
        jsonStringList.add(jsonObject.toJSONString());

        if (file.exists()){
            try {
                String oldFile=FileReadUtil.readRawJson("readingList.json");
                FileWriter writer = new FileWriter(file, false);
                writer.write(oldFile.substring(0,oldFile.length()-1)+", "+jsonStringList.toString()+"]");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to the Json file: " + e.getMessage());
            }

        }
        else {


            try {
                FileWriter writer = new FileWriter(file, true);
                writer.write(jsonStringList.toString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to the Json file: " + e.getMessage());
            }
        }
    }

    public static void addPaperToReadingList(){

    }
}


 */