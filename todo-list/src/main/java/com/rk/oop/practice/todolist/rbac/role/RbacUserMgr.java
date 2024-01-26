package com.rk.oop.practice.todolist.rbac.role;

public class RbacUserMgr {
    private static RoleMgr roleMgr;

    public RbacUserMgr() {
        roleMgr = RoleMgr.getInstance();
    }

    public static void addRoleToUser(RbacUser roleUpdateListener, String roleId) {
        Role role = roleMgr.getRoleById(roleId);
        roleUpdateListener.assignRole(role);
    }

    public static void removeRoleFromUser(RbacUser roleUpdateListener, String roleId) {
        Role role = roleMgr.getRoleById(roleId);
        roleUpdateListener.unAssignRole(role);
    }
}
