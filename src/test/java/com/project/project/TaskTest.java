package com.project.project;

import com.project.project.model.Task;
import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskTest {

    //Title Tests
    @Test
    public void setTitleCorrect() {
        Task t = new Task();

        t.setTitle("ingevuld");

        assertNotNull(t.getTitle());
        assertNotEquals(" ", t.getTitle());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTitleEmpty() {
        Task t = new Task();
        String man = null;

        t.setTitle(man);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTitleSpaces() {
        Task t = new Task();

        t.setTitle("     ");
    }

    //Description Tests
    @Test
    public void setDescriptionCorrect() {
        Task t = new Task();

        t.setDescription("ingevuld");

        assertNotNull(t.getDescription());
        assertNotEquals(" ", t.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDescriptionEmpty() {
        Task t = new Task();
        String man = null;

        t.setDescription(man);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDescriptionSpaces() {
        Task t = new Task();

        t.setDescription("     ");
    }



}
