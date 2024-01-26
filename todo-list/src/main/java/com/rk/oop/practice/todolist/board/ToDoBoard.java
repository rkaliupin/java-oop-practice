package com.rk.oop.practice.todolist.board;

import com.rk.oop.practice.todolist.category.Category;
import com.rk.oop.practice.todolist.category.SimpleCategory;
import com.rk.oop.practice.todolist.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ToDoBoard implements Board {
    private final String id;
    private final String name;
    private ArrayList<User> users;
    private HashMap<String, Category> categories;

    public ToDoBoard(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
    @Override
    public void assignUser(User user) {
        this.users.add(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        return this.users;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Category createCategory(String name) {
        SimpleCategory category = new SimpleCategory(name);

        this.categories.put(name, category);

        return category;
    }

    @Override
    public Category getCategory(String name) {
        return this.categories.getOrDefault(name, null);
    }

    @Override
    public void removeCategory(String name) {
        this.categories.remove(name);
    }
}
