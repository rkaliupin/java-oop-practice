package com.rk.oop.practice.todolist.rbac.role;

public interface RbacUser {
    public void updateRole(Role role);
    public void assignRole(Role role);
    public void unAssignRole(Role role);
    public boolean hasCreatePermission(String permissionId);
    public boolean hasPermission(String permissionId, String resourceId);
    public String getId();
}
