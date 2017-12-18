package main.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private String text;
    private List<Choice> choiceList = new ArrayList<>();

    public Question(String question, String[] wrongAnswers, String correctAnswer) {
        this.text = question;
        shuffleAnswers(wrongAnswers, correctAnswer);
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

    private void shuffleAnswers(String[] wrongAnswers, String correctAnswer) {
        for(int i=0; i<wrongAnswers.length; i++)
            choiceList.add(Choice.wrongOne(wrongAnswers[i]));
        choiceList.add(Choice.correctOne(correctAnswer));
        Collections.shuffle(choiceList);
    }

}

