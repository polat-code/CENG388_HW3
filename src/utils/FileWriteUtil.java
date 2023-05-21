package utils;
/*
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


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


        if (file.exists()){
            try {
                String oldFile=FileReadUtil.readRawJson("readingList.json");
                FileWriter writer = new FileWriter(file, false);
                writer.write(oldFile.substring(0,oldFile.length()-1)+", "+jsonObject.toJSONString()+"]");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to the Json file: " + e.getMessage());
            }

        }
        else {


            try {
                List<String> jsonStringList = new ArrayList<>();
                jsonStringList.add(jsonObject.toJSONString());
                FileWriter writer = new FileWriter(file, true);
                writer.write(jsonStringList.toString());
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error writing to the Json file: " + e.getMessage());
            }
        }
    }

    public static void addPaperToReadingList(int updatedListId, String paperName) throws IOException, ParseException {
        String jsonString=FileReadUtil.readRawJson("readingList.json");
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonString);
        JSONArray jsonArray = (JSONArray) obj;
        JSONArray newJsonArray = new JSONArray();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject= (JSONObject) jsonArray.get(i);
            System.out.println(jsonObject.toJSONString());
            Long reading_list_id = (Long) jsonObject.get("reading_list_id");
            if (reading_list_id == updatedListId){

                String name_of_papers= (String) jsonObject.get("name_of_papers");
                Long number_of_papers= (Long) jsonObject.get("number_of_papers");

                if (number_of_papers==0){
                    jsonObject.put("name_of_papers",paperName);
                }


                else {
                    jsonObject.put("name_of_papers",name_of_papers+", "+paperName);

                }
                jsonObject.put("number_of_papers",number_of_papers+1);

            }
            newJsonArray.add(jsonObject);
        }

        writeStringToJsonFile(newJsonArray.toJSONString(),"readingList.json");



    }




    private static void writeStringToJsonFile(String str,String path) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file, false);
        writer.write(str);
        writer.flush();
        writer.close();
    }



    public static void followResearcher(String followerName, String followingName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("researchers.xml"));

            Element root = document.getDocumentElement();

            NodeList researcherNodes = root.getElementsByTagName("researcher");

            for (int i = 0; i < researcherNodes.getLength(); i++) {
                Element researcherElement = (Element) researcherNodes.item(i);
                String researcherName = researcherElement.getElementsByTagName("researcher_name").item(0).getTextContent();

                if (researcherName.equals(followerName)) {
                    Element followingResearchersElement = (Element) researcherElement.getElementsByTagName("following_researcher_names").item(0);

                    Element followingResearcherElement = document.createElement("following_researcher_name");
                    followingResearcherElement.appendChild(document.createTextNode(followingName));
                    followingResearchersElement.appendChild(followingResearcherElement);
                }

                if (researcherName.equals(followingName)) {
                    Element followerResearchersElement = (Element) researcherElement.getElementsByTagName("follower_researcher_names").item(0);

                    Element followerResearcherElement = document.createElement("follower_researcher_name");
                    followerResearcherElement.appendChild(document.createTextNode(followerName));
                    followerResearchersElement.appendChild(followerResearcherElement);
                }
            }

            saveXMLDocument(document);
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void unfollowResearcher(String followerName, String followingName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("researchers.xml"));

            Element root = document.getDocumentElement();

            NodeList researcherNodes = root.getElementsByTagName("researcher");

            for (int i = 0; i < researcherNodes.getLength(); i++) {
                Element researcherElement = (Element) researcherNodes.item(i);
                String researcherName = researcherElement.getElementsByTagName("researcher_name").item(0).getTextContent();

                if (researcherName.equals(followerName)) {
                    Element followingResearchersElement = (Element) researcherElement.getElementsByTagName("following_researcher_names").item(0);
                    NodeList followingResearcherNodes = followingResearchersElement.getElementsByTagName("following_researcher_name");

                    for (int j = 0; j < followingResearcherNodes.getLength(); j++) {
                        Element followingResearcherElement = (Element) followingResearcherNodes.item(j);
                        String followingResearcher = followingResearcherElement.getTextContent();

                        if (followingResearcher.equals(followingName)) {
                            followingResearchersElement.removeChild(followingResearcherElement);
                            break;
                        }
                    }
                }

                if (researcherName.equals(followingName)) {
                    Element followerResearchersElement = (Element) researcherElement.getElementsByTagName("follower_researcher_names").item(0);
                    NodeList followerResearcherNodes = followerResearchersElement.getElementsByTagName("follower_researcher_name");

                    for (int j = 0; j < followerResearcherNodes.getLength(); j++) {
                        Element followerResearcherElement = (Element) followerResearcherNodes.item(j);
                        String followerResearcher = followerResearcherElement.getTextContent();

                        if (followerResearcher.equals(followerName)) {
                            followerResearchersElement.removeChild(followerResearcherElement);
                            break;
                        }
                    }
                }
            }

            saveXMLDocument(document);
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void saveXMLDocument(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File("researchers.xml"));
        transformer.transform(source, result);
        System.out.println("XML file updated successfully.");
    }

}


 */