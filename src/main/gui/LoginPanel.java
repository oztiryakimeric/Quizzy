package main.gui;

import main.core.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel implements LoginListener{
    private JFrame parentView;
    private LoginController controller;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JButton newUserButton;

    public LoginPanel(JFrame owner) {
        //JLabel label = new JLabel("Login Panel");
        //this.add(label);
        //setBackground(Color.red);
        initializeViews();
    }

    private void initializeViews() {
        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        usernameTextField = new JTextField();
        passwordTextField = new JTextField();
        loginButton = new JButton("Login");
        newUserButton = new JButton("New User");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(newUserButton);
        this.setLayout(new GridBagLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,2));
        JLabel userName = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        panel1.add(userName);
        panel1.add(usernameTextField);
        panel1.add(password);
        panel1.add(passwordTextField);
        mainPanel.add(panel1);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);

    }

    private void login(String username, String password) {

    }

    private void displayError(String message) {

    }

    @Override
    public void loginSuccessfull() {

    }

    @Override
    public void errorOccured(String message) {

    }
}
