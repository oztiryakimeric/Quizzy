package main.gui;

import main.core.NewUserController;
import main.database.User;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 */
public class NewUserPanel extends JPanel implements NewUserListener{
    private JFrame parentView;
    private NewUserController controller;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField password2TextField;
    private JTextField emailTextField;

    public NewUserPanel(JFrame owner) {
        JLabel label = new JLabel("New User Panel");
        this.add(label);
        setBackground(Color.blue);
    }

    private void initializeViews() {

    }

    private User createNewUser(String username, String password, String email) {
        return null;
    }

    private void displayError() {

    }

    @Override
    public void newUserCreated(User user) {

    }

    @Override
    public void errorOccured(String message) {

    }
}
