package main.core;

import main.database.User;
import main.gui.MainFrame;
import main.gui.ScorePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class ScoreController implements ActionListener {
    private MainFrame frame;
    private ScorePanel gui;

    public ScoreController(MainFrame frame, ScorePanel gui) {
        this.frame = frame;
        this.gui = gui;
        gui.setTable(setMap());
        gui.addActionListener(this);
    }

    private HashMap<User,Integer> setMap(){
        HashMap<User,Integer> top10Map = new HashMap<User, Integer>();
        return top10Map;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(gui.getBackButton())) {
            frame.showLoginPage();
        }

    }
}
