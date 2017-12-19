package main.database;

import java.util.Stack;


public class Quiz {
    private Stack<Question> questionStack;
    private Question currentQuestion;
    private int point;

    public Quiz(Stack<Question> questionStack) {
        this.questionStack = questionStack;
        if(!this.isFinished())
            this.currentQuestion = this.questionStack.pop();
    }

    public static Quiz getQuiz(Category category){
        return Api.getQuiz(category);
    }

    public boolean isFinished() {
        return questionStack.isEmpty();
    }

    public Question getNextQuestion() {
        if(!this.isFinished()) {
            currentQuestion = questionStack.pop();
            return currentQuestion;
        }
        return null;
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
