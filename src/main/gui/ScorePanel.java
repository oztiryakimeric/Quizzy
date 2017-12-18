package main.gui;

import main.database.Api;
import main.database.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ScorePanel extends JPanel {
    private JTable scoreTable;
    List<User> userList;
    private JButton backButton;

    public ScorePanel(){
        userList = Api.getTop10();
        initializeViews();
        populateTable();
    }

    public void initializeViews() {
        scoreTable = new JTable();

        this.setLayout(new BorderLayout());
        backButton = new JButton("BACK");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(backButton, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(scoreTable);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(scoreTable, BorderLayout.CENTER);

    }

    private void populateTable(){
        String[] headers = {"Username", "Score"};
        String[][] table = new String[10][3];

        for(int i=0; i<userList.size(); i++){
            table[i][0] = userList.get(i).getUsername();
            table[i][1] = String.valueOf(userList.get(i).getPoint());
        }
        TableModel tableModel = new DefaultTableModel(table, headers);
        scoreTable.setModel(tableModel);
    }

    public void addActionListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
