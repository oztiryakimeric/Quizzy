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

    public static User getUser(String username, String password) throws SQLException {

        String sql = "SELECT COUNT(id) FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet rs = db.query(sql);

        if (rs.getInt(0) == 1){
            sql = "SELECT id,email,timestamp FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            rs = db.query(sql);
            return new User(rs.getInt(0),username,rs.getString(1),rs.getLong(2));
        }

        return null;
    }

    public static List<Category> getAllCategories() throws SQLException {

        String sql = "SELECT id,name,timestamp FROM category";
        ResultSet rs = db.query(sql);
        List<Category> tmp = new ArrayList<>();
        while (rs.next())
            tmp.add(new Category(rs.getInt(0), rs.getString(1), rs.getLong(2)));
        return tmp;
    }

    public static Quiz getQuiz(Category category) throws SQLException {

        int categoryID = category.getId();

        String sql = "SELECT id,question, c_anwser, w_answer1, w_answer2, w_answer3 FROM question WHERE " +
                "category_id=" + categoryID +" ORDER BY id DESC LIMIT 10";
        ResultSet rs = db.query(sql);
        Stack<Question> stack = new Stack<>();
        while (rs.next()){
            String[] c1 = {rs.getString("w_answer1"),rs.getString("w_answer2"),rs.getString("w_answer3")};
            Question q1 = new Question(rs.getString("question"), c1,rs.getString("c_answer"));
            stack.push(q1);
        }
        return new Quiz(stack);
        
    }

    public static int givePoint(User user, int point) {
        return 0;
    }
}
