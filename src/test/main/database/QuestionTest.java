package main.database;

/**
 * Created by SEZİN on 12/15/2017.
 */
import main.database.Choice;
import main.database.Question;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by SEZİN on 12/14/2017.
 */
public class QuestionTest {
    //  private Question initialQuestion;
    @Test
    public void solveTest(){
        String[] wrongAnswers = {"asd","sdf","sdfg"};
        Question   question = new Question("bhjb",wrongAnswers,"bjhbjb");
        assertEquals(true,question.solve(new Choice("a",true)));
    }
    @Test
    public void  solveTest1(){
        String[] wrongAnswers = {"asd","sdf","sdfg"};
        Question   question = new Question("bhjb",wrongAnswers,"bjhbjb");
        assertFalse(question.solve(new Choice("a",false)));
    }

    @Test
    public void getTextTest(){
        String[] wrongAnswers = {"asd","sdf","sdfg"};
        Question   question = new Question("bhjb",wrongAnswers,"bjhbjb");
        assertEquals("bhjb",question.getText());
    }
    @Test
    public void getChoiceListTest(){
        String[] wrongAnswers = {"text2","text3","text4"};
        Question   question = new Question("bhjb",wrongAnswers,"text1");
        List<Choice> choiceList = new ArrayList<>();

        Choice choice1 = new Choice("text1",true);
        Choice choice2 = new Choice("text2",false);
        Choice choice3 = new Choice("text3",false);
        Choice choice4 = new Choice("text4",false);

        choiceList.add(choice1);
        choiceList.add(choice2);
        choiceList.add(choice3);
        choiceList.add(choice4);

        for(int i=0; i<question.getChoiceList().size(); i++){
            if(choiceList.get(i).getText().equals(question.getChoiceList().get(i).getText()))
                assertEquals(choiceList.get(i).getText(),question.getChoiceList().get(i).getText());

        }


    }

}
