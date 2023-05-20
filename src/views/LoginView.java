package views;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JLabel usernameLabel = new JLabel("Username:");
    private JTextField usernameTextField = new JTextField(10);

    private JLabel passwordLabel = new JLabel("Password:");
    private JPasswordField passwordTestField = new JPasswordField(10);
    private JButton loginButton = new JButton("Log In");

    LoginView() {


    }
}
