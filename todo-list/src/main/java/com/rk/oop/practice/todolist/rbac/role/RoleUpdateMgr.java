package com.rk.oop.practice.todolist.rbac.role;

import java.util.ArrayList;
import java.util.HashMap;

public class RoleUpdateMgr {
    private HashMap<String, ArrayList<RbacUser>> RbacUser = new HashMap<>();

    public void subscribe(String roleId, RbacUser roleUpdateListener) {
        ArrayList<RbacUser> RbacUser = this.RbacUser.get(roleId);

        if (RbacUser == null) {
            RbacUser = new ArrayList<>();
        }
        RbacUser.add(roleUpdateListener);

        this.RbacUser.put(roleId, RbacUser);
    }

    public void unsubscribe(String roleId, RbacUser roleUpdateListener) {
        this.RbacUser.remove(roleId, roleUpdateListener);
    }

    public void notify(String roleId, Role role) {
        if (this.RbacUser.containsKey(roleId)) {
            this.RbacUser.get(roleId).forEach(listener -> {
                listener.updateRole(role);
            });
        }
    }
}
