package test;

import main.database.Question;
import main.database.Quiz;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * Created by oztiryakimeric on 19.12.2017.
 */
public class QuizTest {

    private Quiz generateQuiz(){
        Stack<Question> questionStack = new Stack<>();

        String[] tmp = {"test_question","test_question","test_question"};

        Question question = new Question("test_question", tmp, "test_question");
        Question question2 = new Question("test_question2", tmp, "test_question");

        questionStack.push(question);
        questionStack.push(question2);

        Quiz quiz = new Quiz(questionStack);
        return quiz;
    }

    @Test
    public void isFinished() throws Exception {
        Quiz quiz = generateQuiz();
        quiz.getNextQuestion();
        assertTrue(quiz.isFinished());
    }

    @Test
    public void isFinished2() throws Exception {
        assertFalse(generateQuiz().isFinished());
    }

    @Test
    public void getNextQuestion() throws Exception {
        Quiz quiz = generateQuiz();
        Question question = quiz.getNextQuestion();
        assertEquals("test_question", question.getText());
    }

    @Test
    public void getCurrentQuestion() throws Exception {
        Quiz quiz = generateQuiz();
        Question question2 = quiz.getCurrentQuestion();
        assertEquals("test_question2", question2.getText());
    }

    @Test
    public void getPoint() throws Exception {
        Quiz quiz = generateQuiz();
        quiz.givePoint(14);
        assertEquals(14, quiz.getPoint());
    }
}