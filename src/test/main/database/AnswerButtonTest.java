package test.main.database;

import main.database.Choice;
import main.gui.AnswerButton;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oztiryakimeric on 19.12.2017.
 */
public class AnswerButtonTest {

    @Test
    public void getChoice() throws Exception {
        Choice choice = Choice.correctOne("test_choice");

        AnswerButton button = new AnswerButton();
        button.setChoice(choice);

        assertEquals(choice, button.getChoice());
    }

    @Test
    public void setChoice() throws Exception {
        Choice choice = Choice.correctOne("test_choice");

        AnswerButton button = new AnswerButton();
        button.setChoice(choice);

        assertEquals(choice, button.getChoice());
    }
}