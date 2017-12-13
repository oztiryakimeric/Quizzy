package main.gui;

import main.database.Choice;

import javax.swing.*;

/**
 * Created by oztiryakimeric on 13.12.2017.
 */
public class AnswerButton extends JButton {
    private Choice choice;

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
        this.setText(choice.getText());
    }
}
