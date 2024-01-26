package com.rk.oop.practice.todolist.task;

import com.rk.oop.practice.todolist.category.Category;
import com.rk.oop.practice.todolist.user.User;

public class SimpleTask implements Task {
    private final Integer id;
    private User assignedTo;
    private User assignedFrom;
    private String title;
    private String description;
    private Category category;

    public SimpleTask(String title, User assignedFrom, User assignedTo, Integer id) {
        this.id = id;
        this.setTitle(title);
        this.setAssignFrom(assignedFrom);
        this.setAssignTo(assignedTo);
    }

    public Integer getId() {
        return this.id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getStatus() {
        return this.category.getName();
    }

    @Override
    public User getAssignedTo() {
        return this.assignedTo;
    }

    @Override
    public void setAssignTo(User user) {
        this.assignedTo = user;
    }

    @Override
    public User getAssignedFrom() {
        return this.assignedFrom;
    }

    @Override
    public void setAssignFrom(User user) {
        this.assignedFrom = user;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
