package main.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://160.153.128.38/quizzy_db";
    static final String USER = "quizzy_admin";
    static final String PASS = "meric96";
    com.mysql.jdbc.Connection conn = null;
    Statement stmt = null;

    public Database() {
        try{
            Class.forName(JDBC_DRIVER);
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection(DB_URL,USER,PASS);

        } catch(SQLException se){
            System.out.println("Problem with JDBC");
            se.printStackTrace();
        } catch(Exception e){
            System.out.println("Problem with Class.forName");
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) throws SQLException {
        stmt = (Statement) conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    /**
    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        ResultSet result = db.query("Show tables");

        while (result.next()){
            System.out.println(result.getString(1));
        }
    }
     **/

}
