package main.gui;

import main.core.ScoreController;
import main.database.Api;
import main.database.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

public class ScorePanel extends JPanel {
    private ScoreController controller;
    private JTable scoreTable;
    private User[] users;
    private Integer[] scores;
    private HashMap<User,Integer> map;
    private JButton backButton;

    public ScorePanel() {
        users = new User[10];
        scores = new Integer[10];
        //setTable(map);
        map = Api.getTop10();
        initializeViews();
    }

    public void initializeViews() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        backButton = new JButton("BACK");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(backButton);
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridBagLayout());
        scoreTable = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(scoreTable);
        String[] headers = {"Username", "Score"};
        String[][] table = new String[10][2];
        for(int i=0; i<10; i++){
            table[i][0] = users[i].getUsername();
            table[i][1] = Integer.toString(scores[i]);
        }
        TableModel tableModel = new DefaultTableModel(table, headers);
        scoreTable.setModel(tableModel);
        tablePanel.add(scoreTable);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
    }

    public void addActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
