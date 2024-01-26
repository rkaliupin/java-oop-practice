package com.rk.oop.practice.todolist.task;

import com.rk.oop.practice.todolist.user.User;

public interface Task {
    public User getAssignedTo();
    public void setAssignTo(User user);
    public User getAssignedFrom();
    public void setAssignFrom(User user);
    public String getTitle();
    public void setTitle(String title);
    public String getDescription();
    public void setDescription(String description);
}
