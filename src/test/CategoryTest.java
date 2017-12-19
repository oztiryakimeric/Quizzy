package test;
import main.database.Api;
import main.database.Category;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by SEZİN on 12/14/2017.
 */
public class CategoryTest {
    @Test
    public void getNameTest() {
        Category category = new Category(5, "science", 120);
        assertEquals("science", category.getName());
    }

    @Test
    public void getTimeStampTest() {
        Category category = new Category(4, "generalCulture",120);
        assertEquals(120, category.getTimestamp());
    }

    @Test
    public void getIdTest() {
        Category category = new Category(4, "generalCulture", 120);
        assertEquals(4, category.getId());

    }

    @Test
    public void getAllTest(){
        Category c1 = new Category(1, "General Culture", 120);
        Category c2 = new Category(2, "Music", 120);
        Category c3 = new Category(3, "Sport", 120);
        Category c4 = new Category(4, "Science", 120);
        Category c5 = new Category(5, "Literature", 120);
        Category c6 = new Category(6, "Geography", 120);

        List<Category> tmp = new ArrayList<>();

        tmp.add(c1);
        tmp.add(c2);
        tmp.add(c3);
        tmp.add(c4);
        tmp.add(c5);
        tmp.add(c6);

        for (int i = 0; i < Api.getAllCategories().size(); i++) {
            if(tmp.get(i).getName().equals(Api.getAllCategories().get(i).getName()))
                assertEquals(tmp.get(i).getName(), Api.getAllCategories().get(i).getName());
        }
    }
}
