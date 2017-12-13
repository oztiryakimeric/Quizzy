package main.database;

import java.util.*;

public class Api {
    public static User createUser(String username, String password, String email) {
        return null;
    }

    public static User getUser(String username, String password) {
        if(username.equals("meric") && password.equals("123"))
            return new User(1, "meric", "meric@gmail.com", new Date());
        return null;
    }

    public static List<Category> getAllCategories() {
        return null;
    }

    public static Quiz getQuiz(Category category) {
        return null;
    }

    public static int givePoint(User user, int point) {
        return 0;
    }
}
