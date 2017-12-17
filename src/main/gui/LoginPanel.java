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
    private JButton scoresButton;

    public LoginPanel() {
        initializeViews();
    }

    private void initializeViews() {
        this.setLayout(new BorderLayout());
        JPanel outerPanel = new JPanel();
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridBagLayout());
        outerPanel.setLayout(new GridBagLayout());

        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        usernameTextField = new JTextField(10);
        passwordTextField = new JTextField(10);
        loginButton = new JButton("Login");
        newUserButton = new JButton("New User");
        scoresButton = new JButton("TOP 10");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        buttonPanel.add(newUserButton);
        buttonPanel.add(new JLabel("                    "));
        buttonPanel.add(loginButton);


        JPanel credentialsPanel = new JPanel();
        credentialsPanel.setLayout(new GridLayout(2,2));


        credentialsPanel.add(usernameLabel);
        credentialsPanel.add(usernameTextField);
        credentialsPanel.add(passwordLabel);
        credentialsPanel.add(passwordTextField);

        mainPanel.add(credentialsPanel);
        mainPanel.add(buttonPanel);
        outerPanel.add(mainPanel);
        scorePanel.add(scoresButton);
        this.add(outerPanel, BorderLayout.CENTER);
        this.add(scorePanel, BorderLayout.NORTH);
    }

    public void displayError(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void addActionListener(ActionListener listener){
        loginButton.addActionListener(listener);
        newUserButton.addActionListener(listener);
        scoresButton.addActionListener(listener);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getNewUserButton() {
        return newUserButton;
    }

    public JButton getScoresButton() {
        return scoresButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }
}
