package main.database;

import java.sql.SQLException;


public class User {
    private int id;
    private String username;
    private String email;
    private long timestamp;
    private int point;

    public User(int id, String username, String email, long timestamp) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.timestamp = timestamp;
    }

    public static User create(String username, String password, String email){
        return Api.createUser(username, password, email);
    }

    public static User authenticate(String username, String password){
        return Api.getUser(username, password);
    }

    public void givePoint(int amount){
        Api.givePoint(this, amount);
    }

    public String getUsername(){
        return username;
    }

    public int getId(){
        return id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
