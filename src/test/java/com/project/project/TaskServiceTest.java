package com.project.project;

import com.project.project.dto.TaskDTO;
import com.project.project.model.Task;
import com.project.project.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void testGetTasks() {
        //setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("task1");
        taskDTO.setDescription("descri");
        taskDTO.setDueDate(LocalDateTime.now());
        taskService.addTask(taskDTO);

        //method to be tested
        List<Task> tasks = taskService.getAllTasks();

        //Checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        assertNotNull(taskDTO);
    }
}