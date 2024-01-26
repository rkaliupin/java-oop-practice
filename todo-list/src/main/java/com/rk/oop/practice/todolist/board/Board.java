package com.rk.oop.practice.todolist.board;

import com.rk.oop.practice.todolist.category.Category;
import com.rk.oop.practice.todolist.user.User;

import java.util.ArrayList;
import java.util.UUID;

public interface Board {
    public void assignUser(User user);
    public ArrayList<User> getUsers();
    public String getName();
    public Category createCategory(String name);
    public Category getCategory(String name);
    public void removeCategory(String name);
}
