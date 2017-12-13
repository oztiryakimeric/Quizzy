package main.core;

import main.database.Quiz;
import main.gui.AnswerButton;
import main.gui.MainFrame;
import main.gui.QuizPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class QuizController implements ActionListener{

    private MainFrame mainFrame;
    private QuizPanel gui;

    private TimeCounter timer;

    public QuizController(MainFrame mainFrame, QuizPanel gui) {
        this.mainFrame = mainFrame;
        this.gui = gui;
        gui.addActionListener(this);
        timer = new TimeCounter(gui.getTimerLabel());
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        AnswerButton answerButton = (AnswerButton) e.getSource();

        if(answerButton.getChoice().isCorrect()){
            Quiz quiz = gui.getQuiz();
            int newPoint = quiz.givePoint(timer.getRemainingTime() + 50);
            gui.updatePoint(newPoint);

            if(!quiz.isFinished()){
                gui.updateQuestion(quiz.getNextQuestion());
                timer.reset();
            }
            else{
                finishQuiz();
            }
        }
        else{
            finishQuiz();

        }
    }

    private void finishQuiz(){
        timer.stop();
        System.out.println("Quiz Finished");
        gui.displayMessage("Quiz Finished");
    }

    private class TimeCounter{
        private JLabel label;

        private Calendar calendar;
        private Timer timer;

        private SimpleDateFormat dateFormat = new SimpleDateFormat("ss");

        public TimeCounter(JLabel label) {
            this.label = label;
            calendar = Calendar.getInstance();
            reset();
        }

        public void start(){
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calendar.add(Calendar.SECOND, -1);
                    label.setText("Time: " + dateFormat.format(calendar.getTime()));

                    if(calendar.get(Calendar.SECOND) <= 0){
                        finishQuiz();
                    }
                }
            });
            timer.start();
        }

        public void stop(){
            timer.stop();
        }

        public void reset(){
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.SECOND, 60);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
        }

        public int getRemainingTime(){
            return calendar.get(Calendar.SECOND);
        }
    }
}


