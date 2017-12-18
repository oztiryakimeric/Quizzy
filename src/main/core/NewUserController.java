package main.core;

import main.database.User;
import main.gui.MainFrame;
import main.gui.NewUserPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
                User user = null;
                try {
                    user = User.create(gui.getUsername(), gui.getPassword(), gui.getEmail());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (user != null) {
                    root.setAuthenticatedUser(user);
                    try {
                        root.showCategoriesPage();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else
                    gui.displayError(String.format("This username or password is already in use."));
            }
            else
                gui.displayError("Mismatching passwords!");
        }
    }
}
