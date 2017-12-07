package main.database;

import java.util.*;

public class Question {
    private String text;
    private List<Choice> choiceList = new ArrayList<>();

    public Question(String question, List<String> wrongAnswers, String correctAnswer) {
        this.text = question;
        shuffleQuestions(wrongAnswers, correctAnswer);
    }

    public List<Choice> getChoiceList() {
        return this.choiceList;
    }

    public String getText() {
        return this.text;
    }

    private void shuffleQuestions(List<String> wrongAnswers, String correctAnswer) {
        for(String text: wrongAnswers)
            choiceList.add(Choice.wrongOne(text));
        choiceList.add(Choice.correctOne(correctAnswer));
        Collections.shuffle(choiceList);
    }

    private static class Choice{
        private String text;
        private boolean type;

        public static Choice correctOne(String text){
            return new Choice(text, true);
        }

        public static Choice wrongOne(String text){
            return new Choice(text, false);
        }

        private Choice(String text, boolean type) {
            this.text = text;
            this.type = type;
        }
    }
}
