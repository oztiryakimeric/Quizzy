package main.gui;

public interface QuizListener {
    void updateTimer(String time);
    void updatePoint(int point);
    void displayCorrectResult();
    void displayWrongResult(String correctAnswer);
    void finishQuiz();
}
