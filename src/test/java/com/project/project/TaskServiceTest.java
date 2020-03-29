package com.project.project;

import com.project.project.dto.TaskDTO;
import com.project.project.model.Task;
import com.project.project.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void testGetTasks() {
        //setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("task1");
        taskDTO.setDescription("descri");
        taskDTO.setDueDate(LocalDateTime.of(2,2,2,1,1));
        taskService.addTask(taskDTO);

        //method to be tested
        List<Task> tasks = taskService.getAllTasks();

        //Checks
        assertEquals("task1", taskDTO.getTitle());
        assertEquals("descri", taskDTO.getDescription());
        assertEquals(LocalDateTime.of(2,2,2,1,1), taskDTO.getDueDate());

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        assertNotNull(taskDTO);
    }
}