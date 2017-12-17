package main.database;

import java.sql.SQLException;
import java.util.*;


public class Quiz {
    private Stack<Question> questionStack;
    private Question currentQuestion;
    private int point;

    public Quiz(Stack<Question> questionList) {
        this.questionStack = questionList;
        this.currentQuestion = questionStack.pop();
    }

    public static Quiz getQuiz(Category category) {
        try {
            return Api.getQuiz(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isFinished() {
        return questionStack.isEmpty();
    }

    public Question getNextQuestion() {
        currentQuestion = questionStack.pop();
        return currentQuestion;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public int getPoint() {
        return point;
    }

    public int givePoint(int p){
        this.point += p;
        return point;
    }
}
