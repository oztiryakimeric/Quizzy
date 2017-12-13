package main.gui;

import main.database.*;
import main.database.Choice;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class QuizPanel extends JPanel{
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel questionTextLabel;
    private List<JButton> answerButtons;
    private Quiz quiz;

    public QuizPanel(Category category) {

        quiz = Quiz.getQuiz(category);

        answerButtons = new ArrayList<>();
        initializeViews();
        updateQuestion(quiz.getCurrentQuestion());
    }

    private void initializeViews() {
        this.setLayout(new BorderLayout());
        initTimerLabel();
        initScoreLabel();
        initQuestionPanel();
    }

    private void initTimerLabel(){
        timerLabel = new JLabel("Time: 60");

        JPanel timerPanel = new JPanel();
        timerPanel.add(timerLabel);

        this.add(timerPanel, BorderLayout.SOUTH);
    }

    private void initQuestionPanel(){
        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridLayout(2,1));

        JPanel questionTextPanel = new JPanel();
        questionTextPanel.setLayout(new GridBagLayout());

        questionTextLabel = new JLabel();
        questionTextPanel.add(questionTextLabel);

        questionPanel.add(questionTextPanel);

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(2,2));

        for(int i=0; i<4; i++){
            JButton button = new JButton();
            answerButtons.add(button);
            answerPanel.add(button);
        }

        questionPanel.add(answerPanel);

        this.add(questionPanel, BorderLayout.CENTER);
    }

    private void initScoreLabel(){
        scoreLabel = new JLabel("Score: 0");

        JPanel scorePanel = new JPanel();
        scorePanel.add(scoreLabel);

        this.add(scorePanel, BorderLayout.NORTH);
    }

    public void addActionListener(ActionListener listener){
        for(JButton button: answerButtons)
            button.addActionListener(listener);
    }

    public void updateTimer(String time) {
        timerLabel.setText("Time: " + time);
    }

    public void updatePoint(int point) {
        scoreLabel.setText("Score: " + Integer.toString(point));
    }

    public void updateQuestion(Question question){
        List<Choice> choices = question.getChoiceList();
        questionTextLabel.setText(question.getText());

        for(int i=0; i<choices.size(); i++){
            answerButtons.get(i).setText(choices.get(i).getText());
        }
    }
}
