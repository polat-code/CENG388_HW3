
/*
import org.json.simple.parser.ParseException;
import utils.FileReadUtil;
import utils.FileWriteUtil;
import views.UserView;
*/
import models.User;
import org.json.simple.parser.ParseException;
import views.UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

    /*
        String a = FileReadUtil.readBibFiles("Homework3");

        FileWriteUtil.WriteCsvFile(a);
        FileWriteUtil.createReadingListOnJsonFile("abc","x");
        FileWriteUtil.addPaperToReadingList(0,"asd");

        System.out.println("Hello world!");

     */
        List<String> firstReadingList = new ArrayList<>();
        firstReadingList.add("a");
        firstReadingList.add("b");
        firstReadingList.add("c");
        firstReadingList.add("f");
        firstReadingList.add("g");
        firstReadingList.add("e");
        firstReadingList.add("h");
        firstReadingList.add("r");
        List<String> secondReadingList = new ArrayList<>();
        secondReadingList.add("1");
        secondReadingList.add("2");
        secondReadingList.add("3");
        secondReadingList.add("4");
        secondReadingList.add("5");
        secondReadingList.add("6");
        secondReadingList.add("7");
        secondReadingList.add("8");


        Map<String, List<String>> map = new HashMap<>();
        map.put("First Reading List",firstReadingList);
        map.put("Second Reading List",secondReadingList);

        // Simple userview usage
        /*
        UserView userView = new UserView(map,new User("ozgurhan","123456","Özgür","Polat"));
        userView.addFollowActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Follow button action listener");
            }
        });
        userView.addUnFollowActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Unfollow button action listener");
            }
        });
        */

    }



}