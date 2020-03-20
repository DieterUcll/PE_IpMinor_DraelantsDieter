package com.project.project.service;


import com.project.project.dto.TaskDTO;
import com.project.project.model.SubTask;
import com.project.project.model.Task;
import com.project.project.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskServiceInterface {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        taskRepo.save(task);
    }


    public Task getTaskById(long id) {
        return taskRepo.getOne(id);
    }

    public void editTask(Task task) {
        Task t = getTaskById(task.getId());
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setDueDate(task.getDueDate());
        t.setSubtasks(task.getSubtasks());
        taskRepo.findAll().add((int) task.getId(), t);
        taskRepo.flush();
    }

    public void addSubTaskToTask(SubTask sub) {
        Task t = getTaskById(sub.getCorsTask());
        t.addSubTask(sub);
        taskRepo.save(t);
    }
}
