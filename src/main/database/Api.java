package main.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Api {
    static Database db = new Database();

    public static User createUser(String username, String password, String email) throws SQLException {
        String sql = "SELECT COUNT(id) FROM user WHERE username ='" + username + "' OR email = '" + email + "'";
        ResultSet rs = db.query(sql);
        if (rs.getInt(0) > 0){
            return null;
        }

        sql = "INSERT INTO user (username, password, email) VALUES ('" + username + "','" + password + "','" + email + "')";
        rs = db.query(sql);

        if (rs.getBoolean(0)){
            sql = "SELECT id FROM user ORDER BY id DESC LIMIT 1";
            rs = db.query(sql);
            return new User(rs.getInt(0),username,email, System.nanoTime());
        }

        return null;
    }

    public static User getUser(String username, String password) {
        if(username.equals("meric") && password.equals("123"))
            return new User(1, "meric", "meric@gmail.com", 120);
        return null;
    }

    public static List<Category> getAllCategories() {
        Category c1 = new Category(1, "General Culture", 120);
        Category c2 = new Category(2, "Music", 120);
        Category c3 = new Category(3, "Sport", 120);
        Category c4 = new Category(4, "Science", 120);
        Category c5 = new Category(5, "Literature", 120);
        Category c6 = new Category(6, "Geography", 120);

        List<Category> tmp = new ArrayList<>();
        tmp.add(c1);
        tmp.add(c2);
        tmp.add(c3);
        tmp.add(c4);
        tmp.add(c5);
        tmp.add(c6);

        return tmp;
    }

    public static Quiz getQuiz(Category category) {
        String[] c1 = {"A)", "B)", "C)"};
        Question q1 = new Question("asdf", c1,":))");

        String[] c2 = {"asdasdas)", "asd)", "asdasd"};
        Question q2 = new Question("xxxxxx", c2,":((((");

        Stack<Question> stack = new Stack<>();
        stack.push(q1);
        stack.push(q2);

        return new Quiz(stack);
    }

    public static int givePoint(User user, int point) {
        return 0;
    }
}
