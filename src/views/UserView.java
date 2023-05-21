package views;

import models.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserView  extends JFrame {
    private DefaultListModel<String> readingListModel;
    private DefaultListModel<String> readingListDetailModel;

    public DefaultListModel<String> getReadingListModel() {
        return readingListModel;
    }

    public void setReadingListModel(DefaultListModel<String> readingListModel) {
        this.readingListModel = readingListModel;
    }

    public DefaultListModel<String> getReadingListDetailModel() {
        return readingListDetailModel;
    }

    public void setReadingListDetailModel(DefaultListModel<String> readingListDetailModel) {
        this.readingListDetailModel = readingListDetailModel;
    }
    private Map<String, List<String>> readingLists;

    private  User userModel;
    private JLabel nameLabel = new JLabel();
    private JLabel surnameLabel = new JLabel();
    private JLabel readingListLabel = new JLabel("Reading List");
    private JLabel readingListDetailLabel = new JLabel();

    private JButton followButton = new JButton("Follow");
    private JButton unfollowButton = new JButton("Unfollow");



    public UserView(Map<String, List<String>> readingLists, User userModel) {
        this.userModel = userModel;

        nameLabel.setText("Name : " +this.userModel.getName());
        nameLabel.setBounds(650,25,100,30);
        this.add(nameLabel);

        surnameLabel.setText("Surname : " + userModel.getSurname());
        surnameLabel.setBounds(650,50,100,30);
        this.add(surnameLabel);

        this.readingListLabel.setBounds(150,110,100,30);
        this.add(readingListLabel);

        this.readingListDetailLabel.setBounds(435,110,200,30);

        this.add(readingListDetailLabel);

        // Buttons
        followButton.setBounds(100,450,200,40);
        this.add(followButton);

        unfollowButton.setBounds(400,450,200,40);
        this.add(unfollowButton);

        this.readingLists = readingLists;
        this.readingListModel = getFirstListModel(this.readingLists.keySet());
        JList<String> listOfReadingList = new JList<>(readingListModel);
        listOfReadingList.setBounds(100,150,200,250);

        this.add(listOfReadingList);



        this.setTitle("Open Research");
        this.setSize(800,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.readingListDetailModel = new DefaultListModel<>();
        JList<String> listOfReadingDetailList = new JList<>(readingListDetailModel);
        listOfReadingDetailList.setBounds(400,150,200,250);



        listOfReadingList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedValue = listOfReadingList.getSelectedValue();
                List<String> readingList = readingLists.get(selectedValue);
                changeListItems(readingList);
                readingListDetailLabel.setText(selectedValue);

            }
        });
        this.add(listOfReadingDetailList);

        this.setVisible(true);


    }

    private void changeListItems(List<String> readingList) {
        DefaultListModel<String> listModel = getReadingListDetailModel();
        listModel.clear();
        for(String item : readingList) {
            listModel.addElement(item);
        }

    }

    private DefaultListModel<String> getFirstListModel(Set<String> strings) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(String item : strings) {
            listModel.addElement(item);
        }
        return listModel;
    }
    public void addFollowActionListener(ActionListener actionListener) {
        this.followButton.addActionListener(actionListener);
    }

    public void addUnFollowActionListener(ActionListener actionListener) {
        this.unfollowButton.addActionListener(actionListener);
    }
}
