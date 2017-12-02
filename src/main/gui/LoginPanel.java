package main.gui;

import main.core.LoginController;

import javax.swing.*;
import java.util.*;

/**
 *
 */
public class LoginPanel extends JPanel implements LoginListener{
    private JFrame parentView;
    private LoginController controller;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JButton newUserButton;

    public LoginPanel(JFrame owner) {

    }

    private void initializeViews() {

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
