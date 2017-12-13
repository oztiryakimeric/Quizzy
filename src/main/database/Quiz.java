package main.database;

import java.util.*;


public class Quiz {
    private Stack<Question> questionStack;
    private Question currentQuestion;
    private int point;

    public Quiz(Stack<Question> questionList) {
        this.questionStack = questionList;
    }

    public static Quiz getQuiz(Category category) {
        return Api.getQuiz(category);
    }

    public boolean isFinished() {
        return questionStack.isEmpty();
    }

    public Question getNextQuestion() {
        currentQuestion = questionStack.pop();
        return currentQuestion;
    }

    public boolean answerQuestion(Choice choice) {
        if(currentQuestion.solve(choice)){
            //Give point...
            return true;
        }
        else{
            //Finish quiz...
            return false;
        }
    }

    public int getPoint() {
        return point;
    }
}
