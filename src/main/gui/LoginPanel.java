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
        this.parentView = owner;
        this.controller = new LoginController(this);
        initializeViews();
    }

    private void initializeViews() {
        this.setLayout(new GridBagLayout());

        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        usernameTextField = new JTextField();
        passwordTextField = new JTextField();
        loginButton = new JButton("Login");
        newUserButton = new JButton("New User");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        buttonPanel.add(loginButton);
        buttonPanel.add(newUserButton);


        JPanel credentialsPanel = new JPanel();
        credentialsPanel.setLayout(new GridLayout(2,2));

        credentialsPanel.add(usernameLabel);
        credentialsPanel.add(usernameTextField);
        credentialsPanel.add(passwordLabel);
        credentialsPanel.add(passwordTextField);

        mainPanel.add(credentialsPanel);
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
