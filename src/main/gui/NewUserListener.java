package main.gui;

import main.database.User;

public interface NewUserListener {

    void newUserCreated(User user);
    void errorOccured(String message);

}
