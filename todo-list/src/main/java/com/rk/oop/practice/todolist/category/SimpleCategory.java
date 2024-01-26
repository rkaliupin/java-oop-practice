package com.rk.oop.practice.todolist.category;

import com.rk.oop.practice.todolist.task.Task;

import java.util.HashMap;

public class SimpleCategory implements Category {
    private final String name;

    public SimpleCategory(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return null;
    }
}
