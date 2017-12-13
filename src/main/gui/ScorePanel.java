package main.gui;

import main.core.ScoreController;
import main.database.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.lang.reflect.Array;
import java.util.*;

public class ScorePanel extends JPanel {
    private JFrame parentView;
    private ScoreController controller;
    private JTable scoreTable;
    private User[] users;
    private Integer[] scores;
    private HashMap<User,Integer> map;

    public ScorePanel(JFrame owner) {
        users = new User[10];
        scores = new Integer[10];
        initializeViews();
    }

    public void initializeViews() {
        scoreTable = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(scoreTable);
        String[] headers = {"Username", "Score"};
        String[][] table = new String[10][2];
        for(int i=0; i<table.length; i++){
            table[i][0] = users[i].getUsername();
            table[i][1] = Integer.toString(scores[i]);
        }
        TableModel tableModel = new DefaultTableModel(table, headers);
        scoreTable.setModel(tableModel);
        this.add(scoreTable);

    }

    public void setTable(HashMap<User,Integer> map){
        Set<User> users = map.keySet();
        Collection<Integer> scores = map.values();
        this.users = (User[]) users.toArray();
        this.scores = (Integer[])scores.toArray();
    }
}
