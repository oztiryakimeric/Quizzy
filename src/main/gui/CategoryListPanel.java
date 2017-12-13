package main.gui;

import main.core.CategoryListController;
import main.database.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 *
 */
public class CategoryListPanel extends JPanel {
    private JFrame parentView;
    private CategoryListController controller;
    private List<Category> categoryList;
    private List<JButton> categoryButtons;


    public CategoryListPanel(JFrame owner) {
        categoryList = Category.getAll();
        categoryButtons = new ArrayList<JButton>() ;
        initializeViews();
    }
    private void initializeViews() {
        for(int i = 0; i < categoryList.size(); i++) {
            categoryButtons.add(new JButton(categoryList.get(i).getName()));
        }
        JPanel categories = new JPanel();
        categories.setLayout(new GridLayout(6,1));
        for(int i = 0; i < categoryButtons.size(); i++) {
            categories.add(categoryButtons.get(i));
        }
        this.setLayout(new GridBagLayout());
        this.add(categories);
    }

    private Category categorySelected(Category category) {
       return null;// bu methoda neden ihtiyaç var anlayamadık
    }

    private JButton buttonIsSelected() {
        for(int i = 0; i < categoryButtons.size(); i++) {
            if(categoryButtons.get(i).isSelected()) {
                return categoryButtons.get(i);
            }
        }
        return null;
    }

    public void addActionListener(ActionListener listener){
        buttonIsSelected().addActionListener(listener);
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public List<JButton> getCategoryButtons() {
        return categoryButtons;
    }
}
