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
        this.permissions.put(permission.getType(), permission);
    }
    public void removePermission(String permissionId) {
        this.permissions.remove(permissionId);
    }
    public Boolean hasPermission(String permissionId, String resourceId) {
        Permission permission = this.permissions.getOrDefault(permissionId, null);
        return permission != null && permission.hasResource(resourceId);
    }
    public Boolean hasCreatePermission(String permissionId) {
        Permission permission = this.permissions.getOrDefault(permissionId, null);
        return permission != null;
    }
    public String getId() {
        return this.id;
    }
}
