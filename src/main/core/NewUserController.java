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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gui.isValidPassword()){
            try{
                User user = User.create(gui.getUsername(), gui.getPassword(), gui.getEmail());
                root.setAuthenticatedUser(user);
                root.showCategoriesPage();
            }
            catch(Exception ex){
                //if same user registered display error. Api must throw erorr.
            }
        }
    }
}
