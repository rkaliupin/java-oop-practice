package com.rk.oop.practice.todolist.rbac.permission;

import java.util.ArrayList;

public class Permission {
    private final String type;
    private final ArrayList<String> resources;

    public Permission (String type) {
        this.resources = new ArrayList<>();
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public void addResource(String resourceId) {
        this.resources.add(resourceId);
    }
    public boolean hasResource(String resourceId) {
        return this.resources.contains(resourceId);
    }
    public ArrayList<String> getResources() {
        return this.resources;
    }
}
