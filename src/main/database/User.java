package main.database;

import java.sql.SQLException;
import java.util.*;


public class User {
    private int id;
    private String username;
    private String email;
    private long timestamp;

    public User(int id, String username, String email, long timestamp) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.timestamp = timestamp;
    }

    public static User create(String username, String password, String email) throws SQLException {
        return Api.createUser(username, password, email);
    }

    public String getUsername(){
        return username;
    }

    public static User authenticate(String username, String password) {
        return Api.getUser(username, password);
    }
}
