package utils;
/*
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileReadUtil {

    public static List<String> readFilenamesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        List<String> arrListFileNames= new ArrayList<>();
        if (directory.exists() && directory.isDirectory()) {
            String[] filenames = directory.list();

            if (filenames != null) {
                for (String filename : filenames) {
                    arrListFileNames.add(filename);

                }
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        return arrListFileNames;

    }

    public static String readBibFiles(String filePath){
        List<String> fileNames = readFilenamesInDirectory(filePath);
        String csvString="";
        for (int i = 1; i < fileNames.size(); i+=2) {
            File file = new File(filePath+"/"+fileNames.get(i));
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line=br.readLine();

                if (line.contains("@article")){
                    csvString+="article, ";
                    while ((line = br.readLine()) != null) {
                        if (!line.equals("}")){
                            csvString+= articleLineSplit(line);
                        }

                        // Process each line of the BibTeX file
                    }
                }
                else if (line.contains("@inproceedings")){
                    csvString+="conference paper, ";
                    while ((line = br.readLine()) != null) {
                        if (!line.equals("}")){
                            csvString+=conferencePaperLineSplit(line);
                        }

                        // Process each line of the BibTeX file
                    }
                }
                csvString+=RandomUtil.createRandomNumberOfDownloads();
                csvString+="\n";

            } catch (IOException e) {
                System.out.println("Error reading BibTeX file: " + e.getMessage());
            }
        }
        return csvString;


    }

    private static String articleLineSplit(String line){
        String csvLine="";
        String lineValue = line.split("=")[1];
        lineValue = lineValue.substring(2,lineValue.length()-2);
        if (line.contains("author")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("title")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("year")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("volume")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("number")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("doi")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("journal")){
            csvLine=lineValue+", ";
        }
        else {
            csvLine="";
        }


        // Process each line of the BibTeX file

        return csvLine;
    }

    private static String conferencePaperLineSplit(String line){
        String csvLine;
        String lineValue = line.split("=")[1];
        lineValue = lineValue.substring(2,lineValue.length()-2);
        if (line.contains("author")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("title")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("year")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("doi")){
            csvLine=lineValue+", ";
        }
        else if (line.contains("bookTitle")){
            csvLine=lineValue+", ";
        }
        else{
            csvLine="";
        }

        return csvLine;
    }


    public static String readRawJson(String path) throws IOException {
        File file=new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bf = new BufferedReader(fileReader);
        return bf.readLine();

    }

    public static void readJson(){
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader("readingList.json"));

            JSONObject jsonObject = (JSONObject) obj;
            String reading_list_id = (String) jsonObject.get("reading_list_id");

            String creator_researcher_name = (String) jsonObject.get("creator_researcher_name");

            String reading_list_name = (String) jsonObject.get("reading_list_name");

            int number_of_papers = (int) jsonObject.get("number_of_papers");

            JSONArray name_of_papers = (JSONArray) jsonObject.get("name_of_papers");

            Iterator<String> iterator = name_of_papers.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}




 */