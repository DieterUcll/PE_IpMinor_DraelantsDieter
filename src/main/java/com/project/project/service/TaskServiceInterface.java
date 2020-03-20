package com.project.project.service;

import com.project.project.dto.TaskDTO;
import com.project.project.model.Task;

import java.util.List;

public interface TaskServiceInterface {
    public List<Task> getAllTasks();

    void addTask(TaskDTO taskDTO);
}
