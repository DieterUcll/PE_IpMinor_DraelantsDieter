package com.project.project;

import com.project.project.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskTest {


    @Test
    public void setTitleCorrect() {
        Task t = new Task();

        t.setTitle("ingevuld");

        assertNotNull(t.getTitle());
        assertNotEquals(" ", t.getTitle());
    }

    @Test
    public void setTitleEmpty() {
        Task t = new Task();
        String man = null;

        t.setTitle(man);
        assertNull(t.getTitle());


    }

    @Test
    public void setTitleSpaces() {
        Task t = new Task();

        t.setTitle("     ");
        assertNull(t.getTitle());

    }



}
