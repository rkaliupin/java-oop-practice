package com.rk.oop.practice.todolist.user;

import com.rk.oop.practice.todolist.board.Board;
import com.rk.oop.practice.todolist.rbac.role.Role;
import com.rk.oop.practice.todolist.rbac.role.RoleUpdateListeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class User implements RoleUpdateListeners {
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

    /*public void assignToBoard(Board board) {
        this.board = board;
    }*/
}
