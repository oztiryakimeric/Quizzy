import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by oztiryakimeric on 1.12.2017.
 */

public class DatabaseChecker {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://160.153.128.38/quizzy_db";
    static final String USER = "quizzy_admin";
    static final String PASS = "meric96";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating test query...");
            stmt = (Statement) conn.createStatement();
            String sql = "SELECT * FROM test_table";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Query executed...");

            while(rs.next())
                if(rs.getString("test").equals("meric")){
                    System.out.println("**********************");
                    System.out.println("*There is no problem.*");
                    System.out.println("**********************");
                }

            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se){
            System.out.println("Problem with JDBC");
            se.printStackTrace();
        } catch(Exception e){
            System.out.println("Problem with Class.forName");
            e.printStackTrace();
        }
    }
}