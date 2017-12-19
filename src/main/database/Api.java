package main.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Api {
    static Database db = new Database();

    public static User createUser(String username, String password, String email){
        try{
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
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static User getUser(String username, String password){
        try{
            String sql = "SELECT COUNT(id) FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = db.query(sql);
            rs.next();


            if (rs.getInt(1) == 1){
                sql = "SELECT id,email,timestamp FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
                rs = db.query(sql);
                rs.next();
                return new User(rs.getInt(1),username,rs.getString(2),rs.getLong(3));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Category> getAllCategories(){
        try{
            String sql = "SELECT id,name,timestamp FROM category";
            ResultSet rs = db.query(sql);
            List<Category> tmp = new ArrayList<>();
            while (rs.next())
                tmp.add(new Category(rs.getInt(1), rs.getString(2), rs.getLong(3)));
            return tmp;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Quiz getQuiz(Category category){
        try{
            int categoryID = category.getId();

            String sql = "SELECT id,question, c_anwser, w_answer, w_answer2, w_answer3 FROM question WHERE " +
                    "category_id=" + categoryID +" ORDER BY id DESC LIMIT 10";
            ResultSet rs = db.query(sql);

            List<Question> tmpList = new ArrayList<>(10);
            Stack<Question> stack = new Stack<>();
            while (rs.next()){
                String[] c1 = {rs.getString("w_answer"),rs.getString("w_answer2"),rs.getString("w_answer3")};
                Question q1 = new Question(rs.getString("question"), c1,rs.getString("c_anwser"));
                tmpList.add(q1);
            }
            Collections.shuffle(tmpList);
            for(Question q: tmpList)
                stack.push(q);
            return new Quiz(stack);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static Api givePoint(User user, int point)g {
        try{
            if (user.getPoint() < point) {
                String sql = "UPDATE user SET score = score + " + point + " WHERE id = " + user.getId();
                int rs = db.query_update(sql);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<User> getTop10(){
        try{
            List<User> users = new ArrayList<>(10);

            String sql = "SELECT id,email,timestamp,score,username FROM user ORDER BY score DESC LIMIT 10";
            ResultSet rs = db.query(sql);

            while (rs.next()){
                User user = new User(rs.getInt("id"),rs.getString("username"),
                        rs.getString("email"),rs.getLong("timestamp"));
                user.setPoint(rs.getInt("score"));
                users.add(user);
            }
            return users;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
