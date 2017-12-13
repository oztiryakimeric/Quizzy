package main.gui;

import main.database.Category;

import javax.swing.*;

public class CategoryButton extends JButton {

    private Category category;

    public CategoryButton(Category category) {
        super(category.getName());
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
