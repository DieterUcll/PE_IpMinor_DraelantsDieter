package com.project.project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    private String title, description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<SubTask> subtasks = new ArrayList<>();


    //Formatter for return
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("': due ' MMMM d',' YYYY 'at' h:mm a").withLocale(Locale.US);

//Default constructor
    public Task() { };
    public Task(String title, String description, LocalDateTime dueDate) {
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
    }

    public void addSubTask(SubTask sub) {
        if(sub == null) {
            throw new IllegalArgumentException("sub is null");
        }
        subtasks.add(sub);
    }



    /******************
    GETTERS AND SETTERS
     ******************/
    public String getTaskFull() {
        return "(id: " + getId() +") " + getTitle() + getDueDateFormatted() ;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public String getDueDateFormatted() {
        return formatter.format(this.dueDate);
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        if(title == null || title.trim().equals("")) {
            throw new IllegalArgumentException("title invalid");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        if(description == null || description.trim().equals("")) {
            throw new IllegalArgumentException("description invalid");
        }
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) {
        if(dueDate != null) {
            this.dueDate = dueDate;
        } else {
            throw new IllegalArgumentException("date invalid");
        }
    }
    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<SubTask> getSubtasks() {
        return subtasks;
    }
    public void setSubtasks(List<SubTask> subTasks) {
        this.subtasks = subTasks;
    }
}
