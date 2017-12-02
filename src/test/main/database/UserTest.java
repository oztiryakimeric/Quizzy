package main.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by oztiryakimeric on 2.12.2017.
 */
class UserTest {
    @Test
    void create() {
        User user = User.create("meric", "123456", "meric@gmail.com");
        assertEquals(null, user);
    }

}