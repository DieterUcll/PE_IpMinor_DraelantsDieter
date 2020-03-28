package com.project.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SubTask {

    @Id
    @GeneratedValue
    private long subId;

    private long corsTask;

    private String title, description;

    //Default constructor
    public SubTask() { };

    public SubTask(String title, String description) {
        setTitle(title);
        setDescription(description);
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().equals("")) {
            throw new IllegalArgumentException("title invalid");
        }
        this.title = title;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().equals("")) {
            throw new IllegalArgumentException("description invalid");
        }
        this.description = description;
    }
    public long getCorsTask() {
        return corsTask;
    }

    public void setCorsTask(Long corsTask) {
        if(corsTask == null) {
            throw new IllegalArgumentException("corsTask is null");
        }
        this.corsTask = corsTask;
    }

}
