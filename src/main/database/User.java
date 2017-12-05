package main.database;

import java.util.*;


public class User {
    private int id;
    private String username;
    private String email;
    private Date timestamp;

    private User(int id, String username, String email, Date timestamp) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.timestamp = timestamp;
    }

    public static User create(String username, String password, String email) {
        return Api.createUser(username, password, email);
    }

    public static User authenticate(String username, String password) {
        return Api.getUser(username, password);
    }
}
