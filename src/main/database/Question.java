package main.database;

import java.util.*;

public class Question {
    private String text;
    private List<Choice> choiceList = new ArrayList<>();

    public Question(String question, String[] wrongAnswers, String correctAnswer) {
        this.text = question;
        shuffleQuestions(wrongAnswers, correctAnswer);
    }

    public boolean solve(Choice choice){
        return choice.isCorrect();
    }

    public List<Choice> getChoiceList() {
        return this.choiceList;
    }

    public String getText() {
        return this.text;
    }

    private void shuffleQuestions(String[] wrongAnswers, String correctAnswer) {
        for(int i=0; i<wrongAnswers.length; i++)
            choiceList.add(Choice.wrongOne(wrongAnswers[i]));
        choiceList.add(Choice.correctOne(correctAnswer));
        Collections.shuffle(choiceList);
    }
}

