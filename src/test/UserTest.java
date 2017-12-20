package test;

import main.database.User;
import org.junit.Test;



import static org.junit.Assert.assertEquals;

/**
 * Created by oztiryakimeric on 2.12.2017.
 */
public class UserTest {
    @Test
    public void createTest() {
        User user = User.create("meric", "123456", "meric@gmail.com");
        assertEquals(null, user);
    }
    @Test
    public void authenticateTest() {
        User user = User.authenticate("sezin","1234");
        assertEquals(null, user);
    }
}