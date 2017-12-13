package main.core;

import main.database.User;
import main.gui.LoginPanel;
import main.gui.MainFrame;
import sun.applet.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener{

    private LoginPanel gui;
    private MainFrame root;

    public LoginController(LoginPanel gui, MainFrame owner) {
        this.gui = gui;
        this.root = owner;
        gui.addActionListener(this);
    }

    public User authenticate(String username, String password) {
        return User.authenticate(username, password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(gui.getLoginButton())){
            User user = authenticate(gui.getUsernameTextField().getText(), gui.getPasswordTextField().getText());
            if(user != null){
                root.setAuthenticatedUser(user);
                root.showCategoriesPage();
                return;
            }
            else{
                gui.displayError("Invalid login credentials.");
            }
        }
        else if(e.getSource().equals(gui.getNewUserButton())){
            root.showNewUserPage();
        }
    }
}
