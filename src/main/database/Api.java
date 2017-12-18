package main.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Api {
    static Database db = new Database();

    public static User createUser(String username, String password, String email) throws SQLException {
        String sql = "SELECT COUNT(id) FROM user WHERE username ='" + username + "' OR email = '" + email + "'";
        ResultSet rs = db.query(sql);
        rs.next();
        if (rs.getInt(1) > 0){
            return null;
        }

        sql = "INSERT INTO user (username, password, email) VALUES ('" + username + "','" + password + "','" + email + "')";
        int res = db.query_update(sql);
        if (res == 1){
            sql = "SELECT id FROM user ORDER BY id DESC LIMIT 1";
            rs = db.query(sql);
            rs.next();
            return new User(rs.getInt(1),username,email, System.nanoTime());
        }

        return null;
    }

    public static User getUser(String username, String password) throws SQLException {

        String sql = "SELECT COUNT(id) FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet rs = db.query(sql);
        rs.next();

        if (rs.getInt(1) == 1){
            sql = "SELECT id,email,timestamp FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            rs = db.query(sql);
            rs.next();
            return new User(rs.getInt(1),username,rs.getString(2),rs.getLong(3));
        }

        return null;
    }

    public static List<Category> getAllCategories() throws SQLException {

        String sql = "SELECT id,name,timestamp FROM category";
        ResultSet rs = db.query(sql);
        List<Category> tmp = new ArrayList<>();
        while (rs.next())
            tmp.add(new Category(rs.getInt(1), rs.getString(2), rs.getLong(3)));
        return tmp;
    }

    public static Quiz getQuiz(Category category) throws SQLException {

        int categoryID = category.getId();

        String sql = "SELECT id,question, c_anwser, w_answer, w_answer2, w_answer3 FROM question WHERE " +
                "category_id=" + categoryID +" ORDER BY id DESC LIMIT 10";
        ResultSet rs = db.query(sql);
        Stack<Question> stack = new Stack<>();
        while (rs.next()){
            String[] c1 = {rs.getString("w_answer"),rs.getString("w_answer2"),rs.getString("w_answer3")};
            Question q1 = new Question(rs.getString("question"), c1,rs.getString("c_anwser"));
            stack.push(q1);
        }
        return new Quiz(stack);
    }

    public static boolean givePoint(User user, int point) throws SQLException {
        String sql = "UPDATE user SET score += " + point + " WHERE id = " + user.getId();
        int rs = db.query_update(sql);
        if (rs == 1){
            return true;
        }
        return false;
    }

    public static HashMap<Integer, User> getTop10() throws SQLException {

        HashMap<Integer, User> tmp = new HashMap<>();

        String sql = "SELECT id,email,timestamp,score,username FROM user ORDER BY score DESC LIMIT 10";
        ResultSet rs = db.query(sql);

        while (rs.next()){
            tmp.put(rs.getInt("score"),new User(rs.getInt("id"),rs.getString("username"),
                    rs.getString("email"),rs.getLong("timestamp")));
        }


        return tmp;

    }
}
