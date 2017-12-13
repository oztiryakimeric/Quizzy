package main.database;

import java.util.*;

public class Api {
    public static User createUser(String username, String password, String email) {
        return null;
    }

    public static User getUser(String username, String password) {
        if(username.equals("meric") && password.equals("123"))
            return new User(1, "meric", "meric@gmail.com", new Date());
        return null;
    }

    public static List<Category> getAllCategories() {
        Category c1 = new Category(1, "Sport", new Date());
        Category c2 = new Category(1, "c2", new Date());
        Category c3 = new Category(1, "c3", new Date());
        Category c4 = new Category(1, "c4", new Date());
        Category c5 = new Category(1, "c5", new Date());
        Category c6 = new Category(1, "c6", new Date());

        List<Category> tmp = new ArrayList<>();
        tmp.add(c1);
        tmp.add(c2);
        tmp.add(c3);
        tmp.add(c4);
        tmp.add(c5);
        tmp.add(c6);

        return tmp;
    }

    public static Quiz getQuiz(Category category) {
        String[] c1 = {"A)", "B)", "C)"};
        Question q1 = new Question("asdf", c1,":))");

        String[] c2 = {"asdasdas)", "asd)", "asdasd"};
        Question q2 = new Question("xxxxxx", c2,":((((");

        Stack<Question> stack = new Stack<>();
        stack.push(q1);
        stack.push(q2);

        return new Quiz(stack);
    }

    public static int givePoint(User user, int point) {
        return 0;
    }
}
