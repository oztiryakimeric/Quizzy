package main.core;

import main.database.Category;
import main.gui.CategoryButton;
import main.gui.CategoryListPanel;
import main.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CategoryListController implements ActionListener{
    private final MainFrame root;
    private final CategoryListPanel gui;

    public CategoryListController(MainFrame owner, CategoryListPanel gui) {
        this.root = owner;
        this.gui = gui;
        gui.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryButton button = (CategoryButton) e.getSource();
        root.showQuizPage(button.getCategory());
    }
}
