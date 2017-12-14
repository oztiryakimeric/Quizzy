package main.core;

import main.database.User;
import main.gui.MainFrame;
import main.gui.NewUserPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserController implements ActionListener{

    private MainFrame root;
    private NewUserPanel gui;

    public NewUserController(MainFrame root, NewUserPanel gui) {
        this.root = root;
        this.gui = gui;
        gui.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(gui.getRegisterButton())) {
            try{
            User user = User.create(gui.getUsername(), gui.getPassword(), gui.getEmail());
            if (user != null) {
                if(gui.isValidPassword()) {
                    root.setAuthenticatedUser(user);
                    root.showCategoriesPage();
                }
                else{
                    gui.displayError("Mismatching passwords!");
                }
            } else {
                gui.displayError("Invalid register credentials.");
            }
        } else if (e.getSource().equals(gui.getRegisterButton())) {
            root.showNewUserPage();
        }
        catch(Exception e){

            }
    }
}
