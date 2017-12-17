package main.database;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by oztiryakimeric on 2.12.2017.
 */
class UserTest {
    @Test
    void create() throws SQLException {
        User user = User.create("meric", "123456", "meric@gmail.com");
        assertEquals(null, user);
    }
    @Test
    void authenticate () throws SQLException {
        User user = User.authenticate("sezin","1234");
        assertEquals(null,user);
    }
}