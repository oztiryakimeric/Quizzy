package main.gui;

import main.Game;
import main.core.*;
import main.database.Api;
import main.database.Category;
import main.database.User;

import javax.swing.*;
import java.sql.SQLException;


public class MainFrame extends JFrame {
    private JPanel currentPanel;
    private User authenticatedUser;

    public MainFrame() {
        super(Game.APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 600);

        showLoginPage();


        this.setVisible(true);
    }

    private void drawPanel(JPanel panel){
        currentPanel = panel;
        setContentPane(currentPanel);
        invalidate();
        validate();
    }

    public void showLoginPage() {
        LoginPanel panel = new LoginPanel();
        LoginController controller = new LoginController(this, panel);
        drawPanel(panel);
    }

    public void showNewUserPage() {
        NewUserPanel panel = new NewUserPanel();
        NewUserController controller = new NewUserController(this, panel);
        drawPanel(panel);
    }

    public void showCategoriesPage() throws SQLException {
        CategoryListPanel panel = new CategoryListPanel();
        CategoryListController controller = new CategoryListController(this, panel);
        drawPanel(panel);
    }

    public void showQuizPage(Category category) throws SQLException {
        QuizPanel panel = new QuizPanel(category);
        QuizController controller = new QuizController(this, panel);
        drawPanel(panel);
    }

    public void showScorePage() {
        ScorePanel panel = new ScorePanel();
        ScoreController controller = new ScoreController(this, panel);
        drawPanel(panel);
    }

    public void setAuthenticatedUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }
}
