package com.rk.oop.practice.todolist.board;

import com.rk.oop.practice.todolist.category.Category;
import com.rk.oop.practice.todolist.category.SimpleCategory;
import com.rk.oop.practice.todolist.rbac.errors.RbacErrorHandler;
import com.rk.oop.practice.todolist.rbac.permission.PermissionConstants;
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
    public void assignUser(User user, User userToAssign) {
        if (!user.hasPermission(PermissionConstants.ASSIGN_USER_TO_BOARD, this.getName())) {
            RbacErrorHandler.accessDeniedError(user, PermissionConstants.ASSIGN_USER_TO_BOARD, this.getName());
            return;
        }
        this.users.add(userToAssign);
    }

    @Override
    public ArrayList<User> getUsers(User user) {
        if (!user.hasPermission(PermissionConstants.GET_USER_FROM_BOARD, this.getName())) {
            RbacErrorHandler.accessDeniedError(user, PermissionConstants.GET_USER_FROM_BOARD, this.getName());
        }
        return this.users;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Category createCategory(User user, String name) {
        if (!user.hasPermission(PermissionConstants.CREATE_CATEGORY, this.getName())) {
            RbacErrorHandler.accessDeniedError(user, PermissionConstants.CREATE_CATEGORY, this.getName());
            return null;
        }
        SimpleCategory category = new SimpleCategory(name);

        this.categories.put(name, category);

        return category;
    }

    @Override
    public Category getCategory(User user, String name) {
        return this.categories.getOrDefault(name, null);
    }

    @Override
    public void removeCategory(User user, String name) {
        if (!user.hasPermission(PermissionConstants.DELETE_CATEGORY, this.getName())) {
            RbacErrorHandler.accessDeniedError(user, PermissionConstants.DELETE_CATEGORY, this.getName());
            return;
        }
        this.categories.remove(name);
    }
}
