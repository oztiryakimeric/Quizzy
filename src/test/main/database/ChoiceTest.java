package main.database;

/**
 * Created by SEZİN on 12/15/2017.
 */

import main.database.Choice;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by SEZİN on 12/14/2017.
 */
public class ChoiceTest {
    @Test
    public void isCorrectTest(){
        Choice choice = new Choice("bhjb",true);
        assertEquals(true,choice.isCorrect());
    }
    @Test
    public void isCorrectTest2(){
        Choice choice = new Choice("bhjb",false);
        assertEquals(false,choice.isCorrect());
    }
    @Test
    public void getTextTest(){
        Choice choice = new Choice("bhjb",true);
        assertEquals("bhjb",choice.getText());
    }
    @Test
    public void correctOneTest(){
        assertTrue(Choice.correctOne("text1").isCorrect());
    }

    @Test
    public void wrongOneTest(){
        assertFalse(Choice.wrongOne("text1").isCorrect());

    }
}
