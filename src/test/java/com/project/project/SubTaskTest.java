package com.project.project;

import com.project.project.model.SubTask;
import com.project.project.model.Task;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class SubTaskTest {

    //Title Tests
    @Test
    public void setTitleCorrect() {
        SubTask t = new SubTask();

        t.setTitle("ingevuld");

        assertNotNull(t.getTitle());
        assertNotEquals(" ", t.getTitle());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTitleEmpty() {
        SubTask t = new SubTask();
        String man = null;

        t.setTitle(man);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTitleSpaces() {
        SubTask t = new SubTask();

        t.setTitle("     ");
    }

    //Description Tests
    @Test
    public void setDescriptionCorrect() {
        SubTask t = new SubTask();

        t.setDescription("ingevuld");

        assertNotNull(t.getDescription());
        assertNotEquals(" ", t.getDescription());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDescriptionEmpty() {
        SubTask t = new SubTask();
        String man = null;

        t.setDescription(man);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setDescriptionSpaces() {
        SubTask t = new SubTask();

        t.setDescription("     ");
    }

}
