package com.project.project.controller;


import com.project.project.dto.TaskDTO;
import com.project.project.model.SubTask;
import com.project.project.model.Task;
import com.project.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService service) {
        this.taskService = service;
    }


    @RequestMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("index");
    }

    @RequestMapping("/tasks")
    public ModelAndView getTasks() {
        var a = new ModelAndView("tasks");
        a.addObject("tasks", taskService.getAllTasks());
        System.out.println(taskService.getAllTasks().toString());
        return a;
    }

    @RequestMapping("/tasks/{id}")
    public ModelAndView getTaskDetail(@PathVariable(name = "id") int taskId) {

        var a = new ModelAndView("taskDetail");
        a.addObject("detail", taskService.getTaskById(taskId));
        System.out.println("Detail load:" + taskService.getTaskById(taskId).getSubtasks().toString());
        return a;
    }

    @RequestMapping("/taskForm")
    public ModelAndView getCreateTask() {
        return new ModelAndView("createTask");
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute @Valid TaskDTO task) {
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    //Edit handle
    @RequestMapping("/tasks/edit/{id}")
    public ModelAndView getEditForm(@PathVariable(name = "id") int taskId) {
        var a = new ModelAndView("editPage");
        a.addObject("task", taskService.getTaskById(taskId));
        return a;
    }

    @PostMapping("/tasks/edit/change")
    public String editTask(@ModelAttribute() Task task) {
        taskService.editTask(task);
        return "redirect:/tasks/"+task.getId();
    }

    //Subtask handle shit
    @RequestMapping("/tasks/{id}/sub/create")
    public ModelAndView getCreateSubForm(@PathVariable(name = "id") int taskId) {
        var a = new ModelAndView("createSub");
        a.addObject("task", taskService.getTaskById(taskId));
        return a;
    }

    @PostMapping("/newSub")
    public String addSubTask(@ModelAttribute SubTask subTask) {
        long taskId = subTask.getCorsTask();
        taskService.addSubTaskToTask(subTask);
        return "redirect:/tasks/"+taskId;
    }
}
