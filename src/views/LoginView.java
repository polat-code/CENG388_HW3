package views;

import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JLabel logInLabel = new JLabel("Log In");
    private JLabel usernameLabel = new JLabel("Username:");
    private JTextField usernameTextField = new JTextField(10);

    private JLabel passwordLabel = new JLabel("Password:");
    private JPasswordField passwordTextField = new JPasswordField(10);
    private JButton loginButton = new JButton("Log In");


    public LoginView() {
        JPanel content = new JPanel();
        content.setLayout(null);
        content.add(logInLabel);
        logInLabel.setBounds(235, 50,100,35);
        content.add(usernameLabel);
        usernameLabel.setBounds(140,100,125,35);
        content.add(usernameTextField);
        usernameTextField.setBounds(220,100,150,35);
        content.add(passwordLabel);
        passwordLabel.setBounds(140,165,125,35);
        content.add(passwordTextField);
        passwordTextField.setBounds(220, 165,150,35);
        content.add(loginButton);
        loginButton.setBounds(140,225,230,40);
        this.setContentPane(content);
        this.setSize(500,500);
        this.setLocation(700,400);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
