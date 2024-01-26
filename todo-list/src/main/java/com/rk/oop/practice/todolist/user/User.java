package com.rk.oop.practice.todolist.user;

import com.rk.oop.practice.todolist.board.Board;
import com.rk.oop.practice.todolist.rbac.role.Role;
import com.rk.oop.practice.todolist.rbac.role.RbacUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User implements RbacUser {
    private String id;
    private String name;
    private String email;
    private HashMap<String, Role> roles;
    private ArrayList<Board> boards;

    public User(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void updateRole(Role role) {
       this.roles.put(role.getId(), role);
    }

    @Override
    public void assignRole(Role role) {
        this.roles.put(role.getId(), role);
    }

    @Override
    public void unAssignRole(Role role) {
        this.roles.remove(role.getId());
    }

    @Override
    public boolean hasPermission(String permissionId, String resourceId) {
        boolean hasPermission = false;

        for (Map.Entry<String, Role> entry : this.roles.entrySet()) {
            Role role = entry.getValue();

            if (role.hasPermission(permissionId, resourceId)) {
                hasPermission = true;
                break;
            }
        }

        return hasPermission;
    }

    @Override
    public boolean hasCreatePermission(String permissionId) {
        boolean hasPermission = false;

        for (Map.Entry<String, Role> entry : this.roles.entrySet()) {
            Role role = entry.getValue();

            if (role.hasCreatePermission(permissionId)) {
                hasPermission = true;
                break;
            }
        }

        return hasPermission;
    }
}
