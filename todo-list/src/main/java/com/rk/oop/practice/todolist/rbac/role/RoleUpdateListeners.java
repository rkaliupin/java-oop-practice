package com.rk.oop.practice.todolist.rbac.role;

public interface RoleUpdateListeners {
    public void updateRole(Role role);
    public void assignRole(Role role);
    public void unAssignRole(Role role);
}
