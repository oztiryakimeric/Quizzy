package main.core;

import main.database.User;
import main.gui.LoginPanel;
import main.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginController implements ActionListener{

    private MainFrame root;
    private LoginPanel gui;

    public LoginController(MainFrame owner, LoginPanel gui) {
        this.root = owner;
        this.gui = gui;
        gui.addActionListener(this);
    }

    public User authenticate(String username, String password) throws SQLException {
        return User.authenticate(username, password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(gui.getLoginButton())){
            User user = null;
            try {
                user = authenticate(gui.getUsernameTextField().getText(), gui.getPasswordTextField().getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if(user != null){
                root.setAuthenticatedUser(user);
                try {
                    root.showCategoriesPage();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            else{
                gui.displayError("Invalid login credentials.");
            }
        }
        else if(e.getSource().equals(gui.getNewUserButton())){
            root.showNewUserPage();
        }
        else if(e.getSource().equals(gui.getScoresButton())){
            try {
                root.showScorePage();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
