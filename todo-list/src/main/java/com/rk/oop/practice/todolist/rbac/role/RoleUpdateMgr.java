package com.rk.oop.practice.todolist.rbac.role;

import java.util.ArrayList;
import java.util.HashMap;

public class RoleUpdateMgr {
    private HashMap<String, ArrayList<RoleUpdateListeners>> roleUpdateListeners = new HashMap<>();

    public void subscribe(String roleId, RoleUpdateListeners roleUpdateListener) {
        ArrayList<RoleUpdateListeners> roleUpdateListeners = this.roleUpdateListeners.get(roleId);

        if (roleUpdateListeners == null) {
            roleUpdateListeners = new ArrayList<>();
        }
        roleUpdateListeners.add(roleUpdateListener);

        this.roleUpdateListeners.put(roleId, roleUpdateListeners);
    }

    public void unsubscribe(String roleId, RoleUpdateListeners roleUpdateListener) {
        this.roleUpdateListeners.remove(roleId, roleUpdateListener);
    }

    public void notify(String roleId, Role role) {
        if (this.roleUpdateListeners.containsKey(roleId)) {
            this.roleUpdateListeners.get(roleId).forEach(listener -> {
                listener.updateRole(role);
            });
        }
    }
}
