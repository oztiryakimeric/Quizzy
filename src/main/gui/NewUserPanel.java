package main.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewUserPanel extends JPanel{
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField password2TextField;
    private JTextField emailTextField;
    private JButton registerButton;

    public NewUserPanel() {
        initializeViews();
    }

    private void initializeViews() {
        this.setLayout(new GridBagLayout());

        usernameTextField = new JTextField(20);
        passwordTextField = new JTextField();
        password2TextField = new JTextField();
        emailTextField = new JTextField();
        registerButton = new JButton("Register");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel passwordLabel2 = new JLabel("Password:");
        JLabel emailLabel = new JLabel("Email:");

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

    public boolean isValidPassword(){
        if(!passwordTextField.getText().equals(password2TextField.getText())){
            displayError("Passwords didn't match");
            return false;
        }
        return true;
    }

    public String getUsername(){
        return usernameTextField.getText();
    }

    public String getPassword(){
        return passwordTextField.getText();
    }

    public String getEmail(){
        return emailTextField.getText();
    }

    public void addActionListener(ActionListener listener){
        registerButton.addActionListener(listener);
    }

    public void displayError(String error) {
        JOptionPane.showMessageDialog(null,error);
    }

    public JButton getRegisterButton(){ return registerButton ;}

}
