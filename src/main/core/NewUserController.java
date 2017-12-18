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
            if (gui.isValidPassword()) {
                User user = User.create(gui.getUsername(), gui.getPassword(), gui.getEmail());

                if (user != null) {
                    root.setAuthenticatedUser(user);
                    root.showCategoriesPage();
                }
                else
                    gui.displayError("This username or password is already in use.");
            }
            else
                gui.displayError("Mismatching passwords!");
        }
    }
}
