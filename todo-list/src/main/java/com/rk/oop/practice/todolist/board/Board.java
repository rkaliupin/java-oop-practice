package com.rk.oop.practice.todolist.board;

import com.rk.oop.practice.todolist.category.Category;
import com.rk.oop.practice.todolist.user.User;

import java.util.ArrayList;
import java.util.UUID;

public interface Board {
    public void assignUser(User user, User userToAssign);
    public ArrayList<User> getUsers(User user);
    public String getName();
    public Category createCategory(User user, String name);
    public Category getCategory(User user, String name);
    public void removeCategory(User user, String name);
}
