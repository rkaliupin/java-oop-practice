package com.rk.oop.practice.todolist.rbac.role;

import com.rk.oop.practice.todolist.rbac.permission.Permission;

import java.util.ArrayList;
import java.util.HashMap;

public class Role {
    private String id;
    private HashMap<String, Permission> permissions;

    public Role(String id) {
        this.id = id;
    }

    public void addPermission(Permission permission) {
        this.permissions.put(permission.getId(), permission);
    }
    public void removePermission(String permissionId) {
        this.permissions.remove(permissionId);
    }
    public Boolean hasPermission(String permissionId) {
        return this.permissions.containsKey(permissionId);
    }
    public String getId() {
        return this.id;
    }
}
