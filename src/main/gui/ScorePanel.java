package main.gui;

import main.database.Api;
import main.database.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class ScorePanel extends JPanel {
    private JTable scoreTable;
    private Object[] users;
    private Object[] scores;
    private HashMap<Integer,User> map;
    private JButton backButton;

    public ScorePanel(){
        users = new User[10];
        scores = new Integer[10];
        //setTable(map);
        map = Api.getTop10();
        initializeViews();
    }

    public void initializeViews() {
        setTable();
        this.setLayout(new BorderLayout());
        backButton = new JButton("BACK");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(backButton, BorderLayout.EAST);
        scoreTable = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(scoreTable);
        String[] headers = {"Username", "Score"};
        String[][] table = new String[10][2];
        for(int i=0; i<users.length; i++){
            table[i][0] = (map.get(scores[i])).getUsername();
            table[i][1] = Integer.toString((Integer)scores[i]);
        }
        TableModel tableModel = new DefaultTableModel(table, headers);
        scoreTable.setModel(tableModel);
        this.add(buttonPanel, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        this.add(scoreTable, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(100,380));
        this.add(panel,BorderLayout.SOUTH);

    }

    private void setTable(){
        Collection<User> users = map.values();
        Set<Integer> scores = map.keySet();
        this.users =  users.toArray();
        this.scores =  scores.toArray();
        Arrays.sort(this.scores);
        Collections.reverse(Arrays.asList(this.scores));
    }

    public void addActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
