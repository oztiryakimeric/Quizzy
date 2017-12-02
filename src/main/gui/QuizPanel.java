package main.gui;

import main.core.QuizController;
import main.database.Category;
import main.database.User;

import javax.swing.*;
import java.util.*;


public class QuizPanel extends JPanel implements QuizListener{
    private JFrame parentView;
    private QuizController controller;
    private JLabel timerLabel;
    private JLabel currentPoint;
    private JLabel questionLabel;
    private List<JButton> answerButtons;

    public QuizPanel(User user, Category category) {

    }

    private void initializeViews() {

    }

    private void questionAnswered(String answer) {

    }

    @Override
    public void updateTimer(String time) {

    }

    @Override
    public void updatePoint(int point) {

    }

    @Override
    public void displayCorrectResult() {

    }

    @Override
    public void displayWrongResult(String correctAnswer) {

    }

    @Override
    public void finishQuiz() {

    }
}
