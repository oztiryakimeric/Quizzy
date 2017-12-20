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
        if(user == null)
            assertEquals(null, user);
        else
            assertEquals(User.authenticate("meric", "123456"),user);
    }
    @Test
    public void authenticateTest() {
        User user = User.authenticate("bengisu","123");
        assertEquals(null, user);
    }
}