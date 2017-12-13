package main.gui;

import main.core.QuizController;
import main.database.*;
import main.database.Choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class QuizPanel extends JPanel{
    private JFrame parentView;
    private JLabel timerLabel;
    private JLabel pointLabel;
    private JLabel questionLabel;
    private List<JButton> answerButtons;
    private Quiz quiz;

    public QuizPanel(JFrame owner, User user, Category category) {
        this.parentView = owner;

        quiz = Quiz.getQuiz(category);

        answerButtons = new ArrayList<JButton>();
        initializeViews();
        System.out.println("Quiz Panel opened");
    }

    private void initializeViews() {
        questionLabel = new JLabel();
        timerLabel = new JLabel("Time: 60");
        pointLabel = new JLabel("Score: 0");

        JPanel qaPanel = new JPanel();
        qaPanel.setLayout(new GridLayout(2,1));

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new GridBagLayout());
        questionPanel.add(questionLabel);
        qaPanel.add(questionPanel);

        JPanel answerPanel = new JPanel();
        JPanel answers = new JPanel();

        answers.setLayout(new GridBagLayout());
        answerPanel.setLayout(new GridLayout(2,2));
        for (int i = 0; i< answerButtons.size(); i++){
            answerPanel.add(answerButtons.get(i));
        }
        answers.add(answerPanel);
        qaPanel.add(answers);
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new GridBagLayout());
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridBagLayout());
        timePanel.add(timerLabel);
        scorePanel.add(pointLabel);
        this.setLayout(new BorderLayout());
        this.add(scorePanel, BorderLayout.NORTH);
        this.add(qaPanel, BorderLayout.CENTER);
        this.add(timePanel, BorderLayout.SOUTH);
    }

    public void addActionListener(ActionListener listener){
        for(JButton button: answerButtons)
            button.addActionListener(listener);
    }

    public void updateTimer(String time) {
        timerLabel.setText("Time: " + time);
    }

    public void updatePoint(int point) {
        pointLabel.setText("Score: " + Integer.toString(point));
    }

    public void updateQuestion(Question question){
        List<Choice> choices = question.getChoiceList();
        questionLabel.setText(question.getText());

        for(int i=0; i<choices.size(); i++){
            answerButtons.get(i).setText(choices.get(i).getText());
        }
    }
}
