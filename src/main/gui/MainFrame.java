package main.gui;

import main.Game;
import main.database.Category;
import main.database.User;

import javax.swing.*;

//Burada uygulama login page ile baslayacagı ıcın showLoginPage() cagrıldı sadece constructor da. Digerleri panellerden
//cagrılıcak.

public class MainFrame extends JFrame {
    private JPanel currentPanel;
    private User authenticatedUser;

    public MainFrame() {
        super(Game.APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 600);

        showLoginPage();

        if (currentPanel != null)
            this.add(currentPanel);

        this.setVisible(true);
    }

    private void drawPanel(JPanel panel){
        getContentPane().removeAll();
        currentPanel = panel;
        revalidate();
    }

    public void showLoginPage() {
        drawPanel(new LoginPanel(this));
    }

    public void showNewUserPage() {
        drawPanel(new NewUserPanel(this));
    }

    public void showCategoriesPage() {
        drawPanel(new CategoryListPanel(this));
    }

    public void showQuizPage(Category category) {
        drawPanel(new QuizPanel(this, authenticatedUser, category));
    }

    public void showScorePage() {
        drawPanel(new ScorePanel(this));
    }
}
