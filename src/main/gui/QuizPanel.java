package main.gui;

import main.core.QuizController;
import main.database.*;
import main.database.Choice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class QuizPanel extends JPanel implements QuizListener{
    private JFrame parentView;
    private QuizController controller;
    private JLabel timerLabel;
    private JLabel currentPoint;
    private JLabel questionLabel;
    private List<JButton> answerButtons;
    private Quiz quiz;

    public QuizPanel(JFrame owner, User user, Category category) {
        quiz = Quiz.getQuiz(category);
        questionLabel = new JLabel();
        answerButtons = new ArrayList<JButton>();
    }

    private void initializeViews() {

        timerLabel = new JLabel("Time: 60");
        currentPoint = new JLabel("Score: 0");
        answerButtons = new ArrayList<JButton>();
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
        scorePanel.add(currentPoint);
        this.setLayout(new BorderLayout());
        this.add(scorePanel, BorderLayout.NORTH);
        this.add(qaPanel, BorderLayout.CENTER);
        this.add(timePanel, BorderLayout.SOUTH);

    }

    private void questionAnswered(String answer) { //buna gerek kalmadı
    }

    private JButton answerSelected() {
        for(int i = 0; i < answerButtons.size(); i++) {
            if(answerButtons.get(i).isSelected()) {
                return answerButtons.get(i);
            }
        }
        return null;
    }

    public void addActionListener(ActionListener listener){
        answerSelected().addActionListener(listener);
    }

    @Override
    public void updateTimer(String time) {
        timerLabel.setText(time);
    }

    @Override
    public void updatePoint(int point) {
        currentPoint.setText(Integer.toString(point));
    }

    public void updateQuestion(Question question){ //bu methodu conrtroller kullanacak eğer cevap doğruysa question ı update edecek
        List<Choice> choices = quiz.getNextQuestion().getChoiceList();
        questionLabel.setText(question.getText());
        answerButtons.clear();
        for(int i=0; i<choices.size(); i++){
            answerButtons.add(new JButton(choices.get(i).getText()));
        }

    }

    @Override
    public void displayCorrectResult() { //bunları direk salalım

    }

    @Override
    public void displayWrongResult(String correctAnswer) {
        //yanlış cevapta quiz bitsin cevap mevap uğraşmayalım allasen
    }

    @Override
    public void finishQuiz() {
        //ne yapıcağımızı anladık ama nasıl yapacağımızı anlayamadık :)))))
    }
}
