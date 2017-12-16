package main.database;

import java.sql.SQLException;
import java.util.*;

public class Category {
    private int id;
    private String name;
    private long timestamp;

    public Category(int id, String name, long timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    public static List<Category> getAll() throws SQLException {
        return Api.getAllCategories();
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public long getTimestamp(){ return timestamp; }
}
