package main.gui;

import main.database.*;
import main.database.Choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class QuizPanel extends JPanel{
    private User user;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    private JLabel questionTextLabel;
    private List<AnswerButton> answerButtons;
    private Quiz quiz;

    public QuizPanel(Category category, User user){
        this.user = user;
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
            AnswerButton button = new AnswerButton();
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

    public void updatePoint(int point) {
        scoreLabel.setText("Score: " + Integer.toString(point));
    }

    public void updateQuestion(Question question){
        List<Choice> choices = question.getChoiceList();
        questionTextLabel.setText(question.getText());

        for(int i=0; i<choices.size(); i++)
            answerButtons.get(i).setChoice(choices.get(i));
    }

    public void displayMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public User getUser() {
        return user;
    }
}
