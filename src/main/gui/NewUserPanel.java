package main.gui;

import main.core.NewUserController;
import main.database.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *
 */
public class NewUserPanel extends JPanel{
    private JFrame parentView;
    private NewUserController controller;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField password2TextField;
    private JTextField emailTextField;
    private JButton registerButton;

    public NewUserPanel(JFrame owner) {
        initializeViews();
    }

    private void initializeViews() {
        usernameTextField = new JTextField(20);
        passwordTextField = new JTextField();
        password2TextField = new JTextField();
        emailTextField = new JTextField();
        registerButton = new JButton("Register");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel passwordLabel2 = new JLabel("Password:");
        JLabel emailLabel = new JLabel("Email:");
        this.setLayout(new GridBagLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(registerButton);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5,2));
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameTextField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailTextField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordTextField);
        mainPanel.add(passwordLabel2);
        mainPanel.add(password2TextField);
        mainPanel.add(new JLabel());
        mainPanel.add(buttonPanel);
        this.add(mainPanel);

    }

    public void addActionListener(ActionListener listener){
        registerButton.addActionListener(listener);
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public JTextField getPassword2TextField() {
        return password2TextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    private User createNewUser(String username, String password, String email) {
        return User.create(username,password,email);
    }

    private void displayError(String error) {
        JOptionPane.showMessageDialog(null,error);
    }
}
