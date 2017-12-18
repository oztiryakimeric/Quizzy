package main.gui;

import main.database.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class CategoryListPanel extends JPanel {
    private List<Category> categoryList;
    private List<CategoryButton> categoryButtons;

    public CategoryListPanel(){
        categoryList = Category.getAll();
        categoryButtons = new ArrayList<>() ;
        initializeViews();
    }

    private void initializeViews() {
        setLayout(new GridLayout(2,3));

        for(int i=0; i<6; i++) {
            CategoryButton button = new CategoryButton(categoryList.get(i));
            this.add(button);
            categoryButtons.add(button);
        }
    }

    public void addActionListener(ActionListener listener){
        for(CategoryButton button: categoryButtons)
            button.addActionListener(listener);
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public List<CategoryButton> getCategoryButtons() {
        return categoryButtons;
    }
}

