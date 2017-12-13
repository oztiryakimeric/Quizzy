package main.gui;

import main.core.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel{
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JButton newUserButton;

    public LoginPanel() {
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

    public void displayError(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void addActionListener(ActionListener listener){
        loginButton.addActionListener(listener);
        newUserButton.addActionListener(listener);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getNewUserButton() {
        return newUserButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }
}
